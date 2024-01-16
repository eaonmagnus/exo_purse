## Commentaires sur le code

### Frameworks, langage & API
- java 8
- cucumber
- selenium
- maven
- https://randomuser.me/api/ (ne nécessite pas de création de compte)
- librairies additionnelles

### Approche POM
L'approche POM (Page Object Model) peut être utilisée pour interagir avec le dom. Dans ce cas, on définit une classe java par 'objet web' que l'on souhaite manipuler. Par exemple, sur un site marchand, on peut imaginer les objets suivants:
- panier
- barre de navigation
- liste produit

Dans notre cas, un seul objet semble pertinent, l'objet 'form'.

Je n'ai pas choisi cette approche dans l'exercice, simplement pour diversifier les méthodes. Effectivement, j'utilise déjà une approche class/objet pour la manipulation de l'API et du randon User.

### Interractions avec les selectors
Il est à noter que certaines expressions peuvent être concaténées, notamment lors de l'interaction avec les selectors du DOM. Dans le code je récupère le selector, puis j'interagis avec. Cela peut évidemment être fait en une étape, mais ça clarifie la relecture.

### Autres scénarios à implémenter
- I fill in the form with only mandatory invalid data (nota, il n'y a pas de validation de données côté formulaire)
- I fill in all the form with valid data
- Submit an empty form

## Anomalies détectées
- il n'y a pas de validation des formats de données