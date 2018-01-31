package org.tserkovnikov.uitests.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.tserkovnikov.uitests.helpers.TestConstants;
import org.tserkovnikov.uitests.pageobject.LoginPage;
import org.tserkovnikov.uitests.pageobject.TestContext;
import org.tserkovnikov.uitests.pageobject.TestContextFactory;

import java.io.IOException;

public class BaseTest {
    LoginPage loginPage;
    TestContext context;

    @BeforeTest
    public void setup() throws IOException {
        TestContextFactory factory = new TestContextFactory();
        this.context = factory.create();
        // мы заходим на эту страницу в каждом тесте, поэтому я вынес это действие сюда (помогает избежать дублирования)
        this.loginPage = new LoginPage(context.getDriver(), TestConstants.URL);
    }

    @AfterTest
    public void tearDown() {
        WebDriver driver = context.getDriver();
        driver.quit();
    }
}
