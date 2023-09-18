package util;

import driver.WebDriverSingleton;
import helpers.Constants;
import jdk.vm.ci.code.site.Call;
import jdk.vm.ci.meta.Constant;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageclasses.LandingPage;
import pageclasses.LoginPage;
import pageclasses.ProductPage;

import java.time.Duration;

@ExtendWith(FailedTestWatcher.class)
public class BaseTest {
    protected static WebDriver driver;
    protected static LandingPage landingPage;
    protected static ProductPage productPage;
    protected static LoginPage loginPage;
    protected static String browserInformation;
    protected static byte[] screenshot;

    @BeforeAll
    public static void setupDriver() {
        driver = WebDriverSingleton.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        landingPage = new LandingPage();
        landingPage.openLandingPage();
        productPage = new ProductPage();
        productPage.fillProductField("Samsung");
        productPage.searchSubmitButton();
        productPage.chooseProduct();
        productPage.addProductToCart();
        productPage.toCheckOut();
        loginPage = new LoginPage();
        loginPage.login(Constants.EMAIL ,Constants.PASSWORD);
    }

    @AfterEach
    public void getTestInformation() {
        browserInformation = getBrowserInformation();
        screenshot = getScreenshot();
    }

    @AfterAll
    public static void closeBrowser() {
        WebDriverSingleton.tearDown();
    }

    private static String getBrowserInformation() {
        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = capabilities.getBrowserName();
        String browserVersion = capabilities.getBrowserVersion();
        return "Browser Name: " + browserName + ", Browser Version: " + browserVersion;
    }

    private static byte[] getScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
