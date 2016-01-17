@txn
Feature: List conferences
  As a listener
  I want to list all Young Blood conferences
  So I can mark from 0 to 10


  Scenario: List all existing conferences
    Given "Charles" is authenticated
    And The following conferences were presented:
      | Speaker | Subject                                                             |
      | Shoun   | Réaliser une bonne recette grâce au concombre                       |
      | Xavier  | Spock, un framework de test venu d’une autre planète                |
      | Romain  | Une stack logicielle pour applications géolocalisées                |
      | Patrick | Pour un front plus digeste, saupoudrez de feuilles de thym !!       |
      | Walid   | La recette pour déployer des applications microservice avec Ansible |
      | Yoann   | Java Agent en Action                                                |
      | Fabrice | Maven, c'est bien, SBT c'est mieux!                                 |
    When He requests a list of all conferences
    Then He should have the following list:
      | Id | Speaker | Subject                                                             | mark |
      | 1  | Shoun   | Réaliser une bonne recette grâce au concombre                       | 0.0  |
      | 2  | Xavier  | Spock, un framework de test venu d’une autre planète                | 0.0  |
      | 3  | Romain  | Une stack logicielle pour applications géolocalisées                | 0.0  |
      | 4  | Patrick | Pour un front plus digeste, saupoudrez de feuilles de thym !!       | 0.0  |
      | 5  | Walid   | La recette pour déployer des applications microservice avec Ansible | 0.0  |
      | 6  | Yoann   | Java Agent en Action                                                | 0.0  |
      | 7  | Fabrice | Maven, c'est bien, SBT c'est mieux!                                 | 0.0  |