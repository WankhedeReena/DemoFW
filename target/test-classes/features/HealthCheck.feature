@healthcheck
Feature: E-commerce Project Web Site Health Check

  Scenario: Navigation to the URL
    Given User navigated to the home application url

  Scenario: User is able to Open the browser, navigate to the URL and Search for Product
    Given User open the browser
    When User Search for product "Laptop"
    Then Search Result page is displayed


  