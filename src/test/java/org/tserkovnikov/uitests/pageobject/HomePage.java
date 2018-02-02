package org.tserkovnikov.uitests.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;

    HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='userHolder']//div[@class='logout']")
    private WebElement logoutForm;

    @FindBy(xpath = "//div[@class='formHolder']//form[@name='loginForm']")
    private WebElement failedAuthorization;

    @FindBy(xpath = "//img[@alt='Бесплатная регистрация']")
    private WebElement freeRegistrationButton;

    public boolean isHomepageLoaded() {
        return logoutForm.isDisplayed();
    }

    public boolean isAuthorizationFailed() {
        return freeRegistrationButton.isDisplayed();
    }
}
