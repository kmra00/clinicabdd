package kibernum.clinica.pages;

public class LoginPage extends BasePage {

    // locators
    private String usernameFieldId = "username";
    private String passwordFieldId = "password";
    private String submitButtonXpath = "//button[@type='submit']";
    private String textErrorXpath = "//*[@id='login-message']/div";


  public void navigateToLogin() {
    navigateTo("https://clinica-modular.netlify.app/");
  } 

  public void enterUser(String usernameInput) {
    write("id", usernameFieldId, usernameInput);
  }

  public void enterPass(String passwordInput) {
    write("id", passwordFieldId, passwordInput);
  }

  public void submitButton() {
    clickElement("xpath", submitButtonXpath);
  }

  public String getErrorLoginMessage() {
    return getElementText("xpath", textErrorXpath);
  }

  public void login(String usernameInput, String passwordInput) {
    navigateToLogin();
    enterUser(usernameInput);
    enterPass(passwordInput);
    submitButton();
  }

}
