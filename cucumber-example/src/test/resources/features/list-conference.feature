Feature: List conferences
  As a listener
  I want to list all Young Blood conferences
  So I can mark from 0 to 10


  Scenario: List all existing conferences
    Given Charles is authenticated
    And The following conferences were presented:
      | Speaker | Subject                                       |
      | Shoun   | Réaliser une bonne recette grâce au concombre |
    When He requests a list of all conferences
    Then He should have the following list:
      | Speaker | Subject                                       |
      | Shoun   | Réaliser une bonne recette grâce au concombre |
