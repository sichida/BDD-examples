@txn
Feature: Edit a character
  As George Lucas
  I need to edit characters
  So I can add skills to them


  Scenario: I should be able to edit an existing character
    Given the following characters exist:
      | name           | actor       | description | imageUrl                                                       |
      | Luke Skywalker | Mark Hamill | The hero    | https://media.timeout.com/images/101902627/1372/1029/image.jpg |
    When George edits the character "Luke Skywalker" with the following data:
      | name           | actor       | description                 | imageUrl                                                       |
      | Luke Skywalker | Mark Hamill | The hero of episodes 4 to 6 | https://media.timeout.com/images/101902627/1372/1029/image.jpg |
    Then the character "Luke Skywalker" should exist
    And the character "Luke Skywalker" should be interpreted by "Mark Hamill"
    And the character "Luke Skywalker" should have a picture
    And the character "Luke Skywalker" should have "The hero of episodes 4 to 6" as description

  Scenario: I shouldn't be able to edit a non existing character
    When George edits the character "Luke Skywalker" with the following data:
      | name           | actor       | description                 | imageUrl                                                       |
      | Luke Skywalker | Mark Hamill | The hero of episodes 4 to 6 | https://media.timeout.com/images/101902627/1372/1029/image.jpg |
    Then an error should have been raised
