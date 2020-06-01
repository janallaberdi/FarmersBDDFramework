package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class HomePage {
    WebDriver driver = null;

    @FindBy(xpath = "(//a[@class='count_grid_2 flip-card'])[1]")
    public WebElement homeButton;

    @FindBy(xpath = "(//input[@name='Zip_Code'])[7]")
    public WebElement zipCode;

    @FindBy(xpath = "(//button[@class='button-cta button-cross-sell home-startquote'])[7]")
    public WebElement getQuoteButton;

    @FindBy(xpath = "(//p[contains(text(), 'Get a home insurance quote')])[2]")
    public WebElement getHomeInsuranceText;

    public HomePage() {
        driver = Driver.get();
        PageFactory.initElements(driver, this);
    }

    public void doClickHomeButton() {

        homeButton.click();
    }

    public YourInfoPage doClickGetQuoteButton() {
        getQuoteButton.click();
        YourInfoPage yourInfoPage = new YourInfoPage();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(yourInfoPage.intropreapp));
        return yourInfoPage;
    }

    public String getPageTitle() {

        return driver.getTitle();
    }

    public String getGetHomeInsuranceText() {

        return getHomeInsuranceText.getText();
    }

    public boolean isZipCodeDisplayed() {

        return zipCode.isDisplayed();
    }
    public void setZipCode(String zipCode) {

        this.zipCode.sendKeys(zipCode);
    }
}
