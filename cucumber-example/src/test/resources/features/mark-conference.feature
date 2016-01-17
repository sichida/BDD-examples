# language: fr
@txn
Fonctionnalité: noter une conférence
  En tant que technophile
  Je veux sélectionner une des conférence auxquelles j'ai assisté
  Afin de donner une note entre 0 et 10


  Scénario: Je note pour la 1ère fois la conférence de Shoun
    Etant donné que "Charles" est authentifié
    Et que les conférences suivantes ont été présentées:
      | Speaker | Subject                                                             |
      | Shoun   | Réaliser une bonne recette grâce au concombre                       |
      | Xavier  | Spock, un framework de test venu d’une autre planète                |
      | Romain  | Une stack logicielle pour applications géolocalisées                |
      | Patrick | Pour un front plus digeste, saupoudrez de feuilles de thym !!       |
      | Walid   | La recette pour déployer des applications microservice avec Ansible |
      | Yoann   | Java Agent en Action                                                |
      | Fabrice | Maven, c'est bien, SBT c'est mieux!                                 |
    Lorsqu' il attribue la note de 5 la conférence de "Shoun"
    Alors la conférence de "Shoun" devrait avoir la note de 5

  Scénario: Je note par deux fois la conférence de Shoun
    Etant donné que "Charles" est authentifié
    Et que les conférences suivantes ont été présentées:
      | Speaker | Subject                                                             |
      | Shoun   | Réaliser une bonne recette grâce au concombre                       |
      | Xavier  | Spock, un framework de test venu d’une autre planète                |
      | Romain  | Une stack logicielle pour applications géolocalisées                |
      | Patrick | Pour un front plus digeste, saupoudrez de feuilles de thym !!       |
      | Walid   | La recette pour déployer des applications microservice avec Ansible |
      | Yoann   | Java Agent en Action                                                |
      | Fabrice | Maven, c'est bien, SBT c'est mieux!                                 |
    Lorsqu' il attribue la note de 5 la conférence de "Shoun"
    Alors la conférence de "Shoun" devrait avoir la note de 5
    Lorsqu' il attribue la note de 7 la conférence de "Shoun"
    Alors la conférence de "Shoun" devrait avoir la note de 6

  Scénario: Je note pour la 1ère fois la conférence de Xavier
    Etant donné que "Charles" est authentifié
    Et que les conférences suivantes ont été présentées:
      | Speaker | Subject                                                             |
      | Shoun   | Réaliser une bonne recette grâce au concombre                       |
      | Xavier  | Spock, un framework de test venu d’une autre planète                |
      | Romain  | Une stack logicielle pour applications géolocalisées                |
      | Patrick | Pour un front plus digeste, saupoudrez de feuilles de thym !!       |
      | Walid   | La recette pour déployer des applications microservice avec Ansible |
      | Yoann   | Java Agent en Action                                                |
      | Fabrice | Maven, c'est bien, SBT c'est mieux!                                 |
    Lorsqu' il attribue la note de 5 la conférence de "Xavier"
    Alors la conférence de "Xavier" devrait avoir la note de 5