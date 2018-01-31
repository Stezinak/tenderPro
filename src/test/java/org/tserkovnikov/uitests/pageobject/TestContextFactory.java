package org.tserkovnikov.uitests.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.tserkovnikov.uitests.helpers.TestConstants;

import java.util.concurrent.TimeUnit;

public class TestContextFactory {
    public TestContext create() {
        // обычно я храню это не хардкодом и в данном класса описываю получение пользователя, пароля и других данных из внешних источников, поэтому это тут, а не в TestConstants
        String username = "SteZz";
        String password = "Y1Kv430";
        WebDriver driver = setupWebdriver();
        return new TestContext(driver, username, password);
    }

    private WebDriver setupWebdriver() {
        System.setProperty(TestConstants.REGISTRYVALUE, getChromeDriverPath());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--kiosk");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        return driver;
    }

    private String getChromeDriverPath() {
        String osVersion = System.getProperty("os.name").toLowerCase();
        if (osVersion.contains("win")) return "libs/chromedriver.exe";
        if (osVersion.contains("nix")) return "libs/chromedriver_unix";
        return null;
    }
}
