@ProductDetails
Feature: ProductDetails

Scenario: User is click on the Product and check the Product Details
Given User open the browser
And User Search for product "earphone"
When User click on any product
Then Product Description is displayed in new tab

