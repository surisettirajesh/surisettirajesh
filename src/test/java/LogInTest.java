import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageclasses.LoginPage;
import util.BaseTest;

import static helpers.Constants.EMAIL;
import static helpers.Constants.PASSWORD;

@Epic("Amazon Store - Account")
@Story("Account Login")
public class LogInTest extends BaseTest {

    @Test
    @Feature("Login to Amazon")
    @Description("Check if user can successfully login")
    public void loginTest() {
        LoginPage loginPage = landingPage.clickSignIn();
        landingPage = loginPage.login(EMAIL, PASSWORD);
    }
}