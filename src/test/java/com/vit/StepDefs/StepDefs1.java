package com.vit.StepDefs;

import com.vit.core.TestContext;
import com.vit.core.WebDriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
    public class StepDefs1 {

        TestContext testContext;
        public Scenario scn;

        @Before
        public void temp(Scenario s) {
            this.scn = s;
        }

        //Dependency Injections using Pico Container
        public StepDefs1(TestContext testContext) {
            this.testContext = testContext;
            this.scn = testContext.scn;
        }

        @Given("User navigated to the home application url")
        public void user_navigated_to_the_home_application_url() {
            
            System.setProperty("webdriver.chrome.driver","D:\\Selenium\\exes\\chromedriver1\\chromedriver.exe");
            //WebDriverFactory.navigateToTheUrl(testContext.base_url);
            testContext.driver.get(testContext.base_url);
            scn.log("Browser navigated to URL: " + testContext.base_url);

            String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
            testContext.cmnPageObjects.validatePageTitleMatch(expected);
        }
    @Given("User open the browser")
    public void user_open_the_browser() {
            user_navigated_to_the_home_application_url();
    }
    @When("User Search for product {string}")
    public void user_search_for_product(String productName)  {
        testContext.cmnPageObjects.SetSearchTextBox(productName);
        testContext.cmnPageObjects.ClickOnSearchButton();
        scn.log("Product Searched: " + productName);
    }
    @Then("Search Result page is displayed")
    public void search_result_page_is_displayed() {
        testContext.searchPageObjects.ValidateProductSearchIsSuccessfull();
    }
    @When("User click on any product")
    public void user_click_on_any_product() {
        testContext.searchPageObjects.ClickOnTheProductLink(0);
    }
    @Then("Product Description is displayed in new tab")
    public void product_description_is_displayed_in_new_tab() {
        WebDriverFactory.switchBrowserToTab();
        scn.log("Switched to the new window/tab");
         WebDriverFactory.switchToOriginalTab();
        testContext.productDescriptionPageObjects.ValidateProductTileIsCorrectlyDisplayed();
        testContext.productDescriptionPageObjects.ValidateAddToCartButtonIsCorrectlyDisplayed();
        }
    @Given("User search for a Product as {string}")
    public void user_search_for_a_product_as(String productName) {
        user_navigated_to_the_home_application_url();
        user_search_for_product(productName)  ;
    }
    @When("User enters minimum as {string} and maximum as {string} in the filter criteria")
    public void user_enters_minimum_as_and_maximum_as_in_the_filter_criteria(String min, String max) {
        testContext.searchPageObjects.FilterSearchResultByPrice(min,max);
    }
    @Then("User is able to see results with price between {int} and {int}")
    public void user_is_able_to_see_results_with_price_between_and(int min, int max) {
       testContext.searchPageObjects.VerifyThatSearchedProductsAreInPriceRange(min,max);
    }


}
