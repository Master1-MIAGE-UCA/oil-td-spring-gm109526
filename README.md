# Projet Dice

**Auteur** : Matthieu GARCIA-GIMENEZ

## Aperçu

Le **projet Dice** est une application Spring Boot conçue pour simuler des lancés de dés et gérer un historique des résultats stockés dans une base de données. Le projet met en œuvre les concepts fondamentaux de Spring Boot, notamment l'injection de dépendances, les services RESTful, les entités JPA, les repositories, ainsi que Swagger pour la documentation API. Lombok est également utilisé pour simplifier le code.

---

## Fonctionnalités

- **Simulation de lancés de dés** : Permet de lancer un ou plusieurs dés.
- **Gestion de l'historique** : Stocke les résultats des lancés dans une base de données.
- **Documentation API** : Intégration de Swagger pour explorer facilement les endpoints disponibles.
- **Simplification du code** : Annotations Lombok pour réduire le code répétitif.

---

## Structure du projet

### 1. **Application principale**

- **`DiceApplication`** : Point d'entrée de l'application. Elle initialise et lance le contexte Spring Boot.

### 2. **Composants principaux**

- **`Dice`** :
  - Un composant simple représentant un dé.
  - Fournit la méthode `roll()` pour simuler un lancé de dé (retourne une valeur aléatoire entre 1 et 6).

### 3. **Entités**

- **`DiceRollLog`** :
  - Une entité JPA représentant un enregistrement des lancés de dés.
  - Champs :
    - `id` : Identifiant unique.
    - `diceCount` : Nombre de dés lancés.
    - `results` : Résultats des dés sous forme de chaîne de caractères séparée par des virgules.
    - `timestamp` : Horodatage du lancé.

### 4. **Repositories**

- **`DiceRollLogRepository`** :
  - Étend `JpaRepository` pour interagir avec la base de données.
  - Fournit des opérations CRUD pour les entités `DiceRollLog`.

### 5. **Services**

- **`DiceService`** :
  - Gère la logique principale de lancer des dés et d'enregistrer les résultats dans la base de données.
  - Fournit la méthode `rollDices(int count)` pour lancer plusieurs dés, enregistrer les résultats et les retourner.

### 6. **Contrôleurs**

- **`DiceController`** :
  - Expose des endpoints pour lancer des dés :
    - `GET /dice/rollDice` : Lance un seul dé.
    - `GET /dice/rollDices/{count}` : Lance `{count}` dés.
- **`DiceLogController`** :
  - Expose un endpoint pour récupérer l'historique des lancés de dés :
    - `GET /diceLogs` : Retourne tous les historiques des lancés sous forme de JSON.

### 7. **Intégration Swagger**

- Fournit une interface de documentation API interactive accessible à [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html).

### 8. **Intégration Lombok**

- Simplifie le code en générant automatiquement les getters, setters et constructeurs pour l'entité `DiceRollLog` grâce à des annotations comme `@Getter` et `@Setter`.

---

## Utilisation

### Accéder à l'application

- **Endpoints de l'API** :

  - **Lancé de dés** :
    - Un seul dé : `GET http://localhost:8081/dice/rollDice`
    - Plusieurs dés : `GET http://localhost:8081/dice/rollDices/{count}` (remplacez `{count}` par le nombre de dés à lancer).
  - **Historique des lancés** :
    - Récupérer les historiques : `GET http://localhost:8081/diceLogs`

- **Swagger UI** :

  - Visitez [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html) pour une interface interactive de documentation API.

### Démarrer le projet

Si vous n'avez pas d'IDE, vous pouvez démarrer le projet en utilisant Gradle depuis la ligne de commande.

1. **Cloner le dépôt** :

   ```bash
   git clone https://github.com/Master1-MIAGE-UCA/oil-td-spring-gm109526
   cd oil-td-spring-gm109526
   ```

2. **Lancer le projet** :

   ```bash
   ./gradlew bootRun
   ```

3. **Vérifier que l'application fonctionne** :

   - Ouvrez votre navigateur et allez sur [http://localhost:8081](http://localhost:8081).
   - Utilisez les liens fournis ou Swagger UI pour interagir avec l'application.

### Tester l'application

- Utilisez un outil comme Postman, cURL ou votre navigateur pour envoyer des requêtes aux endpoints.
- Commandes cURL exemple :
  - Lancer un seul dé :
    ```bash
    curl http://localhost:8081/dice/rollDice
    ```
  - Lancer plusieurs dés (ex. 3 dés) :
    ```bash
    curl http://localhost:8081/dice/rollDices/3
    ```
  - Récupérer les logs :
    ```bash
    curl http://localhost:8081/diceLogs
    ```

---

## Technologies utilisées

- **Spring Boot** : Framework pour développer des applications Java.
- **Base de données H2** : Base de données en mémoire pour stocker les historiques des lancés.
- **Swagger** : Outil de documentation et d'exploration API.
- **Lombok** : Simplification du code grâce à des annotations.
- **Gradle** : Outil de gestion de dépendances et de compilation (Kotlin DSL).

---

## Auteur

**Matthieu GARCIA-GIMENEZ**

Merci d'explorer le projet Dice ! Si vous avez des questions ou des suggestions, n'hésitez pas à me contacter.
