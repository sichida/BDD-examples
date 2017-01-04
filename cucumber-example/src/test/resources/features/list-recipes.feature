@txn
Feature: List recipes
  As a cooker
  I want to list all recipes
  So I can mark from 0 to 10


  Background:
    Given user "shoun" exists
    And his firstname is "Shoun"
    And his lastname is "Ichida"
    And his email address is "shoun@ichida.fr"
    And his company is "Viseo"

  Scenario: List all existing recipes
    Given "shoun" is authenticated
    And The following recipes exist:
      | Name                    | Description                                 |
      | Cucumber salad          | Salad based on cucumber                     |
      | Salad of raw vegetables | Mix of tomatoes, salad, avocado and shrimps |
      | Gherkins                | Pickles                                     |
    When He requests a list of all recipes
    Then He should have the following list:
      | Name                    | Description                                 | mark |
      | Cucumber salad          | Salad based on cucumber                     | 0.0  |
      | Salad of raw vegetables | Mix of tomatoes, salad, avocado and shrimps | 0.0  |
      | Gherkins                | Pickles                                     | 0.0  |