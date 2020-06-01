package pages;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class YourInfoPage {
    WebDriver driver = null;

    @FindBy(id = "Intropreapp")
    public WebElement intropreapp;

    @FindBy(id = "preapp:FirstName")
    public WebElement firstName;

    @FindBy(id = "preapp:LastName")
    public WebElement lastName;

    @FindBy(id = "preapp:datepicker")
    public WebElement dob;

    @FindBy(id = "preapp:Gender:0")
    public WebElement genderMale;

    @FindBy(id = "preapp:Gender:1")
    public WebElement genderFemale;

    @FindBy(id = "preapp:propOccupation")
    public WebElement occupation;

    @FindBy(id = "preapp:maritalStatus")
    public WebElement maritalStatus;

    @FindBy(id = "preapp:StreetAddress")
    public WebElement streetAddress;

    @FindBy(id = "preapp:City")
    public WebElement city;

    @FindBy(id = "preapp:ZipCode")
    public WebElement zipCode;

    @FindBy(id = "preapp:propType:0")
    public WebElement typeHouse;

    @FindBy(id = "preapp:propType:1")
    public WebElement typeTownhouse;

    @FindBy(id = "preapp:donexttbuttonid")
    public WebElement continueButton;


    public YourInfoPage() {
        driver = Driver.get();
        PageFactory.initElements(driver, this);
    }

    public String getIntropreappText() {

        return intropreapp.findElement(By.tagName("h1")).getText();
    }

    public void setFirstName(String firstName) {

        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {

        this.lastName.sendKeys(lastName);
    }

    public void setDob(String dob) {

        this.dob.sendKeys(dob);
    }

    public void setOccupation(String occ) {
        Select select = new Select(occupation);
        select.selectByVisibleText(occ);
    }

    public void maleGenderSelected(String gender) {
        if (gender.equals("Male")) {
            selectRadioButtonOption(genderMale);
        } else {
            selectRadioButtonOption(genderFemale);
        }

    }

    public void setMaritalStatus(String status) {
        Select select = new Select(maritalStatus);
        select.selectByVisibleText(status);
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress.sendKeys(streetAddress);
    }


    public void setCity(String city) {
        this.city.sendKeys(city);
    }

    public void setZipCode(String zipCode) {
        this.zipCode.sendKeys(zipCode);
    }

    public void selectPropertyType(String propertyType) {
        if (propertyType.equals("House")) {
            selectRadioButtonOption(typeHouse);
        } else {
            selectRadioButtonOption(typeTownhouse);
        }
    }

    public void doClickContinueButton() {
        continueButton.click();
    }

    private void selectRadioButtonOption(WebElement radioOption)  {
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioOption);
    }
}
