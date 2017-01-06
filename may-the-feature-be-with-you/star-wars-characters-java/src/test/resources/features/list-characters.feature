# language: fr
Fonctionnalité: Lister les personnages
  En tant que scénariste
  Je souhaite lister tous les personnages
  Afin d'écrire mes scénario


  Scénario: Lister un personnage
    Etant donné que les personnage suivant existent:
      | firstname | lastname  | actor       | description | imageUrl                                                       |
      | Luke      | Skywalker | Mark Hamill | The hero    | https://media.timeout.com/images/101902627/1372/1029/image.jpg |
    Lorsque je demande tous les personnages existants
    Alors je dois avoir 1 personnage
    Et je dois avoir le personnage suivant parmis les résultats :
      | firstname | lastname  | actor       | description | imageUrl                                                       |
      | Luke      | Skywalker | Mark Hamill | The hero    | https://media.timeout.com/images/101902627/1372/1029/image.jpg |
