package kibernum.clinica.pages;

public class RegistroPacientePage extends BasePage {
 // locators 
  private String nombrePacienteLocator = "nombre";
  private String diagnosticoPacienteLocator = "diagnostico";
  private String edadPacienteLocator = "edad";
  private String tratamientoPacienteLocator = "tratamiento";
  private String botonGuardarLocator = "//form[@id='record-form']//button[@type='submit']";
  private String mensajeConfirmacionLocator = "//div[@id='record-message']//*[contains(text(),'%s')]";

  public void enterName(String name) {
    write("id", nombrePacienteLocator, name);
  }

  public void enterDiagnosis(String diagnosis) {
    write("id", diagnosticoPacienteLocator, diagnosis);
  }

  public void enterAge(String age) {
    write("id", edadPacienteLocator, age);
  }

  public void enterTreatment(String treatment) {
    write("id", tratamientoPacienteLocator, treatment);
  }

  public void clickSaveButton() {
    clickElement("xpath", botonGuardarLocator);
  }

  public String getRecordMessage(String expectedText) {
    String finalXpath = String.format(mensajeConfirmacionLocator, expectedText);
    System.err.println(finalXpath);
    return getElement("xpath", finalXpath).getText().trim();
  }

}
