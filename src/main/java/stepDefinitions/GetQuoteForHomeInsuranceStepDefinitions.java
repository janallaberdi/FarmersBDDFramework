package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.YourInfoPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class GetQuoteForHomeInsuranceStepDefinitions {
    HomePage homePage = new HomePage();
    YourInfoPage yourInfoPage = null;
    WebDriver driver = null;

    @Given("User is already on Home Page")
    public void user_is_already_on_Home_Page() {
        driver = Driver.get();
        driver.get(ConfigurationReader.getProperty("url"));
    }

    @Then("title of page is {string}")
    public void title_of_page_is(String title) {

        Assert.assertEquals(title, homePage.getPageTitle());
    }

    @When("User clicks on Home button")
    public void user_clicks_on_Home_button() {

        homePage.doClickHomeButton();
    }

    @Then("User should see {string} and Zip_Code field")
    public void user_should_see_and_Zip_Code_field(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(homePage.getHomeInsuranceText));
        Assert.assertEquals(text, homePage.getGetHomeInsuranceText());
        wait.until(ExpectedConditions.visibilityOf(homePage.zipCode));
        Assert.assertTrue(homePage.isZipCodeDisplayed());
    }

    @Then("User fills Zip_Code with {string} in order get quote")
    public void user_fills_Zip_Code_with_in_order_get_quote(String zipCode) {

        homePage.setZipCode(zipCode);
    }

    @Then("User clicks on Get a quote button")
    public void user_clicks_on_Get_a_quote_button() {
        yourInfoPage = homePage.doClickGetQuoteButton();
    }

    @Then("User should see text {string}")
    public void user_should_see_text(String text) {
        Assert.assertEquals(text, yourInfoPage.getIntropreappText());
    }

    @Then("User types {string} in first name field")
    public void user_types_in_first_name_field(String firstName) {
        yourInfoPage.setFirstName(firstName);
    }

    @Then("User types {string} in last name field")
    public void user_types_in_last_name_field(String lastName) {
        yourInfoPage.setLastName(lastName);
    }

    @Then("User types {string} in Date of Birth field")
    public void user_types_in_Date_of_Birth_field(String dob) {
        yourInfoPage.setDob(dob);
    }

    @Then("User clicks on {string} button in Gender field")
    public void user_clicks_on_button_in_Gender_field(String gender) {
        yourInfoPage.maleGenderSelected(gender);
    }

    @Then("User selects {string} in Occupation field")
    public void user_selects_in_Occupation_field(String occupation) {
        yourInfoPage.setOccupation(occupation);
    }

    @Then("User selects {string} in Marital Status field")
    public void user_selects_in_Marital_Status_field(String status) {
        yourInfoPage.setMaritalStatus(status);
    }

    @Then("User types {string} in Street Address field")
    public void user_types_in_Street_Address_field(String streetAddress) {
        yourInfoPage.setStreetAddress(streetAddress);
    }

    @Then("User types {string} in city field")
    public void user_types_in_city_field(String city) {
        yourInfoPage.setCity(city);
    }

    @Then("User types {string} in zip code field")
    public void user_types_in_zip_code_field(String zipCode) {
        yourInfoPage.setZipCode(zipCode);
    }

    @Then("User selects {string} in property type field")
    public void user_selects_in_property_type_field(String propertyType) {
        yourInfoPage.selectPropertyType(propertyType);
    }

    @Then("User clicks Continue button")
    public void user_clicks_Continue_button() {
        yourInfoPage.doClickContinueButton();
    }

}
