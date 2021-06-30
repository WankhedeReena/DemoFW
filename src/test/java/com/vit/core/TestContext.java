package com.vit.core;
import com.vit.pageobjects.*;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
@Log4j2
public class TestContext {
    public WebDriver driver;
    public String base_url = "https://amazon.in";
    public int implicit_wait_timeout_in_sec = 20;
    public Scenario scn;

    public CmnPageObjects cmnPageObjects;
    public SearchPageObjects searchPageObjects;
    public ProductDescriptionPageObjects productDescriptionPageObjects;

    public void initializeWebDriver() throws Exception {
        //Get the browser name by default it is chrome
        String browserName = WebDriverFactory.getBrowserName();
        driver = WebDriverFactory.getWebDriverForBrowser(browserName)  ;
        log.info("Browser invoked.");
    }

    public void quitDriver(){
        driver.quit();
        log.info("Browser quit.");
    }
    public void intializePageObjects(){
        cmnPageObjects = new CmnPageObjects(driver);
        searchPageObjects = new SearchPageObjects(driver);
        productDescriptionPageObjects = new ProductDescriptionPageObjects(driver);
    }
}


