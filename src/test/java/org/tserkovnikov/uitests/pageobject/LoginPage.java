package org.tserkovnikov.uitests.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "usetenderlogin")
    private WebElement loginInput;

    @FindBy(name = "usetenderpassword")
    private WebElement passwordInput;

    @FindBy(name = "submit")
    private WebElement enterButton;

    public HomePage loginToSystem(String user, String password) {
        loginInput.click();
        loginInput.sendKeys(user);
        passwordInput.click();
        passwordInput.sendKeys(password);
        enterButton.click();
        return new HomePage(driver);
    }
}
