@search
Feature: Search Feature

Scenario: User is able to filter the search based on price
Given User search for a Product as "Laptop"
When User enters minimum as "20000" and maximum as "50000" in the filter criteria
Then User is able to see results with price between 20000 and 50000