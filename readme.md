# Présentation de l'équipe et du projet

### Contexte
Le client a pour habitude de cuisiner matin, midi et soir. Seul bémol, il n'a jamais d'idée.
Dans un premier temps, il souhaite bénéficier d'une application web lui permettant d'ajouter les recettes qu'il connait déjà.

Aussi, il aimerait pouvoir ajouter les recettes qu'il découvre à la télévision ou durant ses sorties au restaurant ou encore chez ses amis.

Il y a une fonctionnalité dont il ne cesse de nous parler : l'application pourra proposer une recette en fonction du moment souhaité. Si la recette a été cuisinée il y a moins de 6 jours, elle ne devra pas apparaitre.

### L'équipe
Hamza Ghanmi, Valentin Fauveau et Alizée Hamon sont les développeurs de ce projet. Ils ont travaillé sans relâche durant 48 heures pour livrer leur solution au client.

### Les outils de travail
- Java avec JDK 8 (supérieur ou égal)
- Serveur Tomcat 10 et Web service Jakarta EE 9
- Servlet 5.0
- HTML5, CSS3, JS ES6, JSP et JSTL 1.2
- Base de données avec JPA (Hibernate 6.0)
- Maven et Git
- API avec JAX-RS (Jersey 3.0)

# Configuration & Lancement du projet
- Le fichier pom.xml doit être implémenté avec les versions des dépendances qui correspondent à la machine du client (selon la version de MySQL et de Java)
- Le fichier persistence.xml doit être rempli avec les données correspondant à la base MySql du client, une architecture est fournie et les indications en majuscules doivent être remplacées par les informations du client
- La base de données doit être créée à partir du fichier .sql fourni
- Un serveur doit être lancé et l'utilisateur doit se rendre sur l'url "/recipes-list" pour trouver la page d'accueil du site
- Pour se connecter, un compte user factice est disponible avec les identifiants suivants:
email: test@test.fr,
mot de passe: test

# Les fonctionnalités disponibles
### Utilisateur non connecté
- Visualiser les recettes (recipes-list)
- S'inscrire (nom, prénom, email, photo, mot de passe) (create-user)
- Se connecter (email, mot de passe) (login)
### Utilisateur connecté
- Editer son profil (nom, prénom, photo, mot de passe) (edit-user)
- Se déconnecter (logout)
- Visualiser les recettes (recipes-list)
- Rechercher une recette par critères (Entrée, Plat..etc) et par mots-clés (Croque...) (recipes-list)
- Ajouter une recette (add-recipe)
- Enregistrer sa recette réalisée à la date du jour à partir d'un bouton (I cooked this)

# Les fonctionnalités à implémenter & les améliorations possibles
- L'API pour l'application mobile pose souci à cause de la conception de la base et des entités
- Demander une recette aléatoire (en fonction de l'instant et de l'historique de moins de 6 jours)
- Supprimer son compte utilisateur
- Visualiser une page de profil utilisateur
- Sauvegarder des recettes réalisées par l'utilisateur dans son profil
- Le CSS n'est pas tout à fait terminé et des animations peuvent être un plus pour l'expérience utilisateur
- Visualiser une liste d'envies de recettes ou un organiseur pour réaliser les recettes au plus proche de ses envies
- Adapter les recettes en fonction des portions demandées par l'utilisateur