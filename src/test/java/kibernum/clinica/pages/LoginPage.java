package kibernum.clinica.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    // locators
    private String usernameFieldId = "username";
    private String passwordFieldId = "password";
    private String submitButtonXpath = "//button[@type='submit']";
    private String textErrorXpath = "//*[@id='login-message']/div";


    private void getDriver(){

    }

    public void login(String usuario,String password){
        WebDriver driver = getDriver();
        driver.findElement(By.id(usernameFieldId)).sendKeys(usuario);
        driver.findElement(By.id(passwordFieldId)).sendKeys(password);
        driver.findElement(By.xpath(submitButtonXpath)).click();
    }

    public String getTextError(){
       List<WebElement> messageError = getDriver().findElements(textErrorXpath);
        return messageError.isEmpty()?"":messageError.get(0).getText().trim();
    }

}
