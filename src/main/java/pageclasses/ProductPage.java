package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class ProductPage extends BasePage {
    Random random;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchProduct;

    @FindBy(css = ".swatch-option.text")
    private List<WebElement> sizeOptions;

    @FindBy(css = ".swatch-option.color")
    private List<WebElement> colorOptions;

    @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
    private WebElement proceedToCheckoutBtn;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartBtn;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchSubmitBtn;

    @FindBy(xpath = "//li[contains(@class, 'item category')][last()]/a")
    private WebElement categoryBtn;

    public ProductPage() {
        super();
        random = new Random();
    }

    public void addProductToCart() {
        addToCartBtn.click();
    }

    public void toCheckOut() {
        proceedToCheckoutBtn.click();
    }

    public void fillProductField(String product) {
        searchProduct.clear();
        searchProduct.isDisplayed();
        searchProduct.sendKeys(product);
    }

    public void searchSubmitButton() {
        searchSubmitBtn.click();
    }

    public void chooseProduct() {
        List<WebElement> resultsList = driver.findElements(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"));
        int size = resultsList.size();
        System.out.println("Size of list = " + size);
        resultsList.get(9).click();
    }

    public void selectSortBy() {
        Select se = new Select(driver.findElement(By.xpath("//*[@id='a-autoid-7-announce']")));

        // Select the option using the visible text
        se.selectByVisibleText("Price: Low to High");
    }

}