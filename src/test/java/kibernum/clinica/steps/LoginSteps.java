package kibernum.clinica.steps;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kibernum.clinica.pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    @Given("que el médico abre la página de inicio de sesión")
    public void que_el_médico_abre_la_página_de_inicio_de_sesión() {
        loginPage = new LoginPage();
        loginPage.navigateToLogin();
    }

    @When("ingresa el usuario {string} y la contraseña {string}")
    public void ingresa_el_usuario_y_la_contraseña(String usuario, String contraseña) {
        loginPage.login(usuario, contraseña);
    }

    @Then("el médico accede a la web {string}")
    public void el_médico_accede_a_la_web(String url) {
        String actualUrl = loginPage.getCurrentUrl();
        assertTrue(actualUrl.contains(url));
    }

    @Then("se ve el mensaje de error {string}")
    public void se_ve_el_mensaje_de_error(String mensajeError) {
        String actualMensajeError = loginPage.getErrorLoginMessage();
        assertEquals(mensajeError, actualMensajeError, "El mensaje de error no coincide"+actualMensajeError);
    }
}
