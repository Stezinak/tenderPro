package org.tserkovnikov.uitests.pageobject;

import org.openqa.selenium.WebDriver;

public class TestContext {
    private final WebDriver driver;
    private final String username;// = "SteZz";
    private final String password;// = "Y1Kv430";

    TestContext(WebDriver driver, String username, String password) {
        this.driver = driver;
        this.username = username;
        this.password = password;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
