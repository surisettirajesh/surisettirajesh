package pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Constants.WEBPAGE;

public class LandingPage extends BasePage {
    @FindBy(css = "a-button-text")
    private WebElement signInBtn;

    public LandingPage() {
        super();
    }


    public void openLandingPage() {
        driver.get(WEBPAGE);
    }

    public LoginPage clickSignIn() {
        signInBtn.click();
        return new LoginPage();
    }



}