package pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "ap_email")
    private WebElement emailField;
    @FindBy(id = "continue")
    private WebElement continueBtn;
    @FindBy(id = "ap_password")
    private WebElement passField;

    @FindBy(id = "signInSubmit")
    private WebElement signInBtn;

    public LoginPage() {
        super();
    }

    public LandingPage login(String email, String password) {
        fillEmailField(email);
        clickContinueButton();
        fillPasswordField(password);
        clickSignInButton();
        return new LandingPage();
    }

    private void fillEmailField(String email) {
        emailField.clear();
        emailField.isDisplayed();
        emailField.sendKeys(email);
    }

    private void clickContinueButton() {
        continueBtn.click();
    }

    private void fillPasswordField(String password) {
        passField.clear();
        passField.isDisplayed();
        passField.sendKeys(password);
    }

    private void clickSignInButton() {
        signInBtn.click();
    }
}