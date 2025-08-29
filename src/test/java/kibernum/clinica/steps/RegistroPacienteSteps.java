package kibernum.clinica.steps;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kibernum.clinica.pages.LoginPage;
import kibernum.clinica.pages.RegistroPacientePage;

public class RegistroPacienteSteps {

    RegistroPacientePage registroPacientePage;

    LoginPage paginaLogin;

    @Given("que el médico inició sesión")
    public void que_el_medico_inicia_sesion() {
        paginaLogin = new LoginPage();
        paginaLogin.navigateToLogin();
        paginaLogin.enterUser("doctor");
        paginaLogin.enterPass("password");
        paginaLogin.submitButton();

        registroPacientePage = new RegistroPacientePage();
    }

    @When("ingresa los datos de la ficha:")
    public void ingresa_los_datos_de_la_ficha(DataTable dataTable) {
        Map<String, String> datosFicha = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> campo : datosFicha.entrySet()) {
            switch (campo.getKey()) {
                case "nombre":
                    registroPacientePage.enterName(campo.getValue());
                    break;
                case "diagnostico":
                    registroPacientePage.enterDiagnosis(campo.getValue());
                    break;
                case "edad":
                    registroPacientePage.enterAge(campo.getValue());
                    break;
                case "tratamiento":
                    registroPacientePage.enterTreatment(campo.getValue());
                    break;
            }
        }
        registroPacientePage.clickSaveButton();
    }

    @When("ingresa el nombre {string}, el diagnóstico {string}, la edad {int} y el tratamiento {string}")
    public void ingresa_el_nombre_el_diagnóstico_la_edad_y_el_tratamiento(
            String nombre, String diagnostico, int edad, String tratamiento) {
        if (tratamiento == null)
            tratamiento = "";
        registroPacientePage.enterName(nombre);
        registroPacientePage.enterDiagnosis(diagnostico);
        registroPacientePage.enterAge(String.valueOf(edad));
        registroPacientePage.enterTreatment(tratamiento);
        registroPacientePage.clickSaveButton();
    }

    @Then("se muestra el mensaje {string}")
    public void se_muestra_el_mensaje(String mensajeEsperado) {
        String mensajeReal = registroPacientePage.getRecordMessage(mensajeEsperado);
        assertTrue(mensajeReal.contains(mensajeEsperado),
                "Mensaje equivocado. Se obtuvo: " + mensajeReal);
    }

}
