# Spring Boot Docker CI/CD Project

## Description du Projet
Ce projet est une application Spring Boot simple, conteneurisée avec Docker, et intégrée avec une pipeline CI/CD via GitLab. Elle expose deux endpoints REST pour démontrer les fonctionnalités de base d'une API :

- **GET /api/hello** : Retourne un message JSON.
- **POST /api/echo** : Renvoie l'objet JSON fourni dans la requête.

---

## Instructions pour cloner le dépôt

1. Clonez le dépôt depuis GitHub :
   ```bash
   git clone https://github.com/OussamaMahmoudiCybersec/projet-devops.git
   cd projet-devops
    ```

2. Assurez-vous d'avoir **Java 17+**, **Maven**, et **Docker** installés sur votre machine.

---

## Instructions pour construire et exécuter l'application

1. **Construire l'application avec Maven :**
    
    ```bash
    mvn clean install
    ```
    
2. **Exécuter l'application localement :**
    
    ```bash
    mvn spring-boot:run
    ```
    
3. **Construire et exécuter l'application avec Docker :**
    
    - Construisez l'image Docker :
        
        ```bash
        docker build -t projet-devops .
        ```
        
    - Lancez le conteneur :
        
        ```bash
        docker run -p 8085:6969 projet-devops
        ```
        
4. **Utiliser Docker Compose (avec PostgreSQL) :**
    
    - Modifiez le fichier `application.properties` pour configurer la base de données.
    - Lancer avec `docker-compose` :
        
        ```bash
        docker-compose up
        ```
        

---

## Commandes pour tester les endpoints

1. **Tester le endpoint GET /api/hello** :
    
    - Avec `curl` :
        
        ```bash
        curl -X GET http://localhost:8085/api/hello
        ```
        
    - Réponse attendue :
        
        ```json
        {
          "message": "Hello, DevOps!"
        }
        ```
        
2. **Tester le endpoint POST /api/echo** :
    
    - Avec `curl` :
        
        ```bash
        curl -X POST http://localhost:8085/api/echo \
        -H "Content-Type: application/json" \
        -d '{"key":"value"}'
        ```
        
    - Réponse attendue :
        
        ```json
        {
          "key": "value"
        }
        ```
        
3. **Tester avec un outil comme Postman** :
    
    - Importez l'URL `http://localhost:8085/api` dans Postman.
    - Configurez les requêtes GET et POST avec leurs paramètres.

---

## Configuration de l'API

Le contrôleur principal se trouve dans le fichier `MainController` et est défini comme suit :

```java
@RequestMapping("/api")
public class MainController {

    @GetMapping("/hello")
    public Map<String, String> sayHello() {
        return Collections.singletonMap("message", "Hello, DevOps!");
    }

    @PostMapping("/echo")
    public ResponseEntity<Object> echo(@RequestBody Object requestBody) {
        return ResponseEntity.ok(requestBody);
    }
}
```
