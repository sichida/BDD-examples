@txn
Feature: Find a character
  As George Lucas
  I need to find characters


  Scenario: I should be able to find an existing character
    Given the following characters exist:
      | name           | actor       | description | imageUrl                                                       |
      | Luke Skywalker | Mark Hamill | The hero    | https://media.timeout.com/images/101902627/1372/1029/image.jpg |
    When George search the character "Luke Skywalker"
    Then the character "Luke Skywalker" should be found

  Scenario: I shouldn't be able to find a non existing character
    When George search the character "Luke Skywalker"
    Then the character "Luke Skywalker" shouldn't be found
