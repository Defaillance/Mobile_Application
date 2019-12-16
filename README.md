# Mobile_Application 4A

## Présentation
Projet donnant un listing des films du studio ghibli avec l'année de parution ainsi que le nom du réalisateur

## Prérequis


- Installation d'Android Studio
- Récupérer la branche develop<br/>


````
https://github.com/LudoCarlu/Pokemon.git
````



## Problémes rencontrés

(- On peut voir une grosse différence entre le deuxième et le troisième commit au niveau du code ar après plusieurs test, j'ai pu remarquer 
que je ne pouvais réaliser un click pour passer au second écran ainsi j'ai été aider pour modifier le code afin de réaliser un click 
convenable

- Le principal problème vient de l'api car au niveau du code le lien entre le premier écran et le deuxième écran est censé être "clean"
seulement si on test l'appli rien ne s'affiche sur le deuxième écran alors que de mon point de vue tout semble normal, ce qui nous donne
un problème d'affichage.) Problèmes rencontrés en 3ème année

- Lors de l'ajout de la bare de recherche ainsi que des fragments, je n'ai pas eu de problèmes particuliers seulement j'ai voulu à plusieurs reprises, ces derniers jours, modifier mon code en envoyant ma fonction "showlist" dans le homefragment seulement il fallait que je modifie mon 'MyController' et 'MyAdapter' ce que j'ai essayé de faire seulement il avait une erreur qui m'empechait de retirer ma fonction showlist du main activity. Ce qui m'a empeché de donner un aspect plus présentable à l'application.

- Problème mineur que j'ai pu rencontrer c'est l'utilisation de 'get.SupportFragmentManager()' qui n'était pas contenue dans l'extension Activity ainsi j'ai cherché une solution alors qu'en changeant cette extension en FragmentActivity tout rentrait dans l'ordre.

## Affichage

### Premier écran
Liste des films avec années de parution.

### Second écran
Nom avec le nom du réalisateur et l'année de parution (normalement s'il n'y avait pas le problème d'affichage).
