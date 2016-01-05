# language: fr
Fonctionnalité: noter une conférence
  En tant que technophile
  Je veux sélectionner une des conférence auxquelles j'ai assisté
  Afin de donner une note entre 0 et 10


  Scénario:
    Etant donné que Charles est authentifié
    Et que les conférences suivantes ont été présentées:
      | Speaker | Subject                                       |
      | Shoun   | Réaliser une bonne recette grâce au concombre |
    Lorsqu' il sélectionne la conférence de "Shoun"
    Et qu'il attribue la note de 5
    Alors la conférence de "Shoun" devrait avoir la note de 5