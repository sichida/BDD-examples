@txn
Feature: Create a character
  As George Lucas
  I need to create characters
  So I can write an awesome story


  Scenario: I should be able to create a character
    When George creates "Luke Skywalker" portrayed by "Mark Hamill"
    Then the character "Luke Skywalker" should exist

  Scenario: I should be able to create a character with full specs
    When George creates the following character:
      | name           | actor       | description | imageUrl                                                       |
      | Luke Skywalker | Mark Hamill | The hero    | https://media.timeout.com/images/101902627/1372/1029/image.jpg |
    Then the character "Luke Skywalker" should exist
    And the character "Luke Skywalker" should be interpreted by "Mark Hamill"
    And the character "Luke Skywalker" should have a picture

  Scenario: I shouldn't be able to create a character twice
    Given the following characters exist:
      | name           | actor       | description | imageUrl                                                       |
      | Luke Skywalker | Mark Hamill | The hero    | https://media.timeout.com/images/101902627/1372/1029/image.jpg |
    When George creates the following character:
      | name           | actor       | description | imageUrl                                                       |
      | Luke Skywalker | Mark Hamill | The hero    | https://media.timeout.com/images/101902627/1372/1029/image.jpg |
    Then an error should have been raised
