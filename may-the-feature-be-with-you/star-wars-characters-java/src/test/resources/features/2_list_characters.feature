# language: fr
@txn
Fonctionnalité: Lister les personnages
  En tant que scénariste
  Je souhaite lister tous les personnages
  Afin d'écrire mes scénario

  Scénario: Lister un personnage
    Etant donné que les personnage suivant existent:
      | name           | actor       | description | imageUrl                                                       |
      | Luke Skywalker | Mark Hamill | The hero    | https://media.timeout.com/images/101902627/1372/1029/image.jpg |
    Lorsque je demande tous les personnages existants
    Alors je dois avoir 1 personnage
    Et je dois avoir le personnage suivant parmis les résultats :
      | name           | actor       | description | imageUrl                                                       |
      | Luke Skywalker | Mark Hamill | The hero    | https://media.timeout.com/images/101902627/1372/1029/image.jpg |

  Scénario: Lister plusieurs personnages
    Etant donné que les personnage suivant existent:
      | name           | actor         | description                    | imageUrl                                                                                      |
      | Luke Skywalker | Mark Hamill   | The hero                       | https://media.timeout.com/images/101902627/1372/1029/image.jpg                                |
      | Obi-Wan Kenobi | Alec Guinness | Jedi hero                      | https://media.timeout.com/images/101902661/1372/1029/image.jpg                                |
      | Leia Organa    | Carrie Fisher | Princess, among Rebel Alliance | https://upload.wikimedia.org/wikipedia/en/1/1b/Princess_Leia%27s_characteristic_hairstyle.jpg |
    Lorsque je demande tous les personnages existants
    Alors je dois avoir 3 personnages
    Et je dois avoir le personnage suivant parmis les résultats :
      | name           | actor       | description | imageUrl                                                       |
      | Luke Skywalker | Mark Hamill | The hero    | https://media.timeout.com/images/101902627/1372/1029/image.jpg |
    Et je dois avoir le personnage suivant parmis les résultats :
      | name           | actor         | description | imageUrl                                                       |
      | Obi-Wan Kenobi | Alec Guinness | Jedi hero   | https://media.timeout.com/images/101902661/1372/1029/image.jpg |
    Et je dois avoir le personnage suivant parmis les résultats :
      | name        | actor         | description                    | imageUrl                                                                                      |
      | Leia Organa | Carrie Fisher | Princess, among Rebel Alliance | https://upload.wikimedia.org/wikipedia/en/1/1b/Princess_Leia%27s_characteristic_hairstyle.jpg |

  Scénario: Lister aucun personnage
    Etant donné que les personnage suivant existent:
      | name | actor | description | imageUrl |
    Lorsque je demande tous les personnages existants
    Alors je dois avoir 0 personnage
