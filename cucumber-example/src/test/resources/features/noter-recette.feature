# language: fr
@txn
Fonctionnalité: noter une recette
  En tant que cuisinier
  Je souhaite noter mes recettes
  Afin de les évaluer


  Scénario: Je peux noter la recette "Salade de concombre"
    Etant donné que "Shoun" est authentifié
    Et que les recettes suivantes existent:
      | Name                | Description                            |
      | Salade de concombre | Salade à base de concombre             |
      | Salade de crudité   | Mélange de salade, tomate et crevettes |
    Lorsqu' il attribue la note de 8 la recette "Salade de concombre"
    Alors la recette "Salade de concombre" devrait avoir la note de 8
