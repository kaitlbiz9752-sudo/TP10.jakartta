## TP : Système d’authentification sécurisé avec Spring Boot, Spring Security, JPA et MySQL



## Démonstration Vidéo :



https://github.com/user-attachments/assets/d3717a7e-929c-47e1-a135-a94dffabb326





**Objectif du TP**

**Ce TP a pour but de mettre en place un système complet d’authentification sécurisé basé sur :**

- Spring Boot

- Spring Security

- Spring Data JPA

- MySQL

- BCrypt pour le hachage des mots de passe

- L’objectif principal est de remplacer l’authentification en mémoire par une authentification persistante dans une base de données.


**Au terme du TP, l’étudiant sera capable de :**

- Créer des entités User et Role.

- Configurer une base MySQL pour stocker les utilisateurs.

- Utiliser un UserDetailsService personnalisé.

- Gérer les rôles et les autorisations.

- Mettre en place un formulaire de login personnalisé.

- Protéger des pages selon les rôles (USER / ADMIN).

- Styliser les pages HTML avec un fichier CSS externe.

## Architecture générale du projet

**L’application suit une architecture MVC simplifiée :**

- entities : classes de mapping JPA (User, Role)

- repositories : accès aux données

- services : logique métier, chargement des utilisateurs

- config : configuration de Spring Security et initialisation BD

- web : contrôleurs MVC

- templates : pages HTML (Thymeleaf)

- static/css : fichier de style global

## Partie Base de données MySQL

- Le TP commence par la création d’une base MySQL dédiée à la sécurité.

**L’application utilise JPA/Hibernate pour créer automatiquement les tables :**

- Table des utilisateurs

- Table des rôles

- Table de relation user/roles

- Le hachage des mots de passe est assuré par l’algorithme BCrypt.

- Une initialisation automatique insère deux utilisateurs :

- admin (rôles ADMIN + USER)

- user (rôle USER)

## Partie Authentification et Sécurité

- La configuration Spring Security permet de :

- Restreindre les pages selon le rôle :

- /admin/** → réservé ADMIN

- /user/** → accessible USER et ADMIN

**Autoriser librement :**

- /login

- /css/**

- Rediriger l’utilisateur après connexion vers /home

- Afficher un message en cas d’erreur de connexion

- Gérer la déconnexion proprement

**L’application utilise :**

- Un DaoAuthenticationProvider

- Un UserDetailsService personnalisé

- Un BCryptPasswordEncoder

## Interface utilisateur

**Les pages Thymeleaf suivantes sont créées :**

- Page de connexion (login)

- Page d’accueil (home)

- Espace utilisateur

- Espace administrateur

- Les pages affichent dynamiquement le rôle de l’utilisateur connecté.

- Un fichier CSS global gère le style visuel (couleurs, présentation…).

## Fonctionnement attendu

**Après démarrage :**

- Page de login accessible sur :

```text
http://localhost:8080/login
```

- Identifiants par défaut :

- admin / 1234 → accès espace administrateur + utilisateur

- user / 1111 → accès espace utilisateur

**Après connexion :**

- Redirection automatique vers la page d’accueil contenant des liens vers :

- Espace utilisateur

- Espace administrateur (si autorisé)

**Déconnexion :**

- Redirection vers /login?logout=true

## Résultats attendus

**À la fin du TP, l'application doit :**

- Gérer correctement les rôles et autorisations.

- Encoder les mots de passe dans la base.

- Permettre la connexion et la déconnexion proprement.

- Proposer une interface propre et stylisée.

- Protéger les ressources sensibles.

- Charger les utilisateurs depuis MySQL au lieu d’une mémoire locale.

## Conclusion

**Ce TP permet de comprendre :**

- La mise en place d’un système d’authentification complet et sécurisé

- La gestion des rôles et des droits d’accès

- L’intégration de Spring Security avec JPA/MySQL

- Le fonctionnement du UserDetailsService

- L’importance du hachage BCrypt

- L’organisation d’un projet Spring Boot conforme aux bonnes pratiques

- C’est un TP fondamental pour toute application nécessitant des comptes utilisateurs et une gestion des permissions.
