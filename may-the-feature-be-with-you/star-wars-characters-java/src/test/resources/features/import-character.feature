@txn
Feature: Import character
  As a scenarist
  I want to import a character from a data source
  In order to add information on character.

  Scenario: Import a character with empty database
    Given Star Wars API responds "data/kenobi_search.json" when searching for "Kenobi"
    When I look for data for the query "Kenobi"
    Then Star Wars API should have answered
    And I should have 1 result in response
    Given I prepare new calls to SWAPI
    And Star Wars API responds "data/kenobi.json" when importing data from "http://swapi.co/api/people/10/"
    When I import data for selected item
    Then Star Wars API should have answered
    And the character "Obi-Wan Kenobi" should exist
    And the character "Obi-Wan Kenobi" should have extra data:
      | gender | height | mass | hairColor     | skinColor | eyeColor  | birthYear |
      | male   | 182    | 77   | auburn, white | fair      | blue-gray | 57BBY     |
