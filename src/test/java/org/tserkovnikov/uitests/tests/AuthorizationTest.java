package org.tserkovnikov.uitests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.tserkovnikov.uitests.pageobject.HomePage;

public class AuthorizationTest extends BaseTest {

    @Test
    public void authorizationToSystem() {
        HomePage homepage = loginPage.loginToSystem(context.getUsername(), context.getPassword());
        Assert.assertTrue(homepage.isHomepageLoaded());
    }

    @Test
    public void authorizationToSystemFailed() {
        HomePage homepage = loginPage.loginToSystem(context.getUsername(), "123456");
        Assert.assertTrue(homepage.isAuthorizationFailed());
    }
}
