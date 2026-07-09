### K1

STD24201

STD24210

STD24219

STD24223

# Library Management API

Ce projet est une API REST de gestion de bibliothèque développée dans le cadre de l'examen pratique de Prog4.  
Elle permet de gérer les livres, les stocks, les éditions, et d’obtenir des indicateurs de performance comme les revenus par genre.

---

##  Fonctionnalités principales

1. **Gestion des stocks**
    - Stock total d’un livre (toutes éditions confondues)
    - Stock d’une édition spécifique d’un livre
    - Liste des produits avec un stock bas (seuil paramétrable, par défaut ≤ 3)

2. **Analyse financière**
    - Revenus générés par genre littéraire (chiffre d’affaires par genre)

3. **Les entités** :
    - Book – Livre
    - Author – Auteur
    - Publisher – Éditeur
    - Category – Catégorie / Genre
    - Edition – Édition d’un livre
    - Stock – Stock d’une édition
    - StockMovement – Mouvement de stock (arrivage, vente, etc.)
    - Supplier – Fournisseur
    - Restocking – Réapprovisionnement
    - Customer – Client
    - Order – Commande
    - OrderLine – Ligne de commande
    - Cart – Panier
    - CartItem – Élément du panier
    - Payment – Paiement
    - Invoice – Facture
    - Employee – Employé
    - Review – Avis / Commentaire
    - Promotion – Promotion / Réduction
    - RevenueByGenre – Chiffre d’affaires par genre (non persistée)


---

##  Technologies

- **Java 21** + **Spring Boot 3.2.2**
- **Gradle** (build)
- **Spring Data JPA** (Hibernate)
- **Base de données** : PostgreSQL (preprod) / H2 (test)
- **Tests** : JUnit 5, Mockito, Spring Boot Test
- **Documentation API** : Swagger / OpenAPI (via springdoc-openapi)
- **CI/CD** : GitHub Actions (exécution automatique des tests)

---

##  Architecture du projet

```text
src/
├── main/
│   ├── java/library/app/com/
│   │   ├── concurrency/         
│   │   ├── datastructure/      
│   │   ├── endpoint/           # Contrôleurs REST
│   │   ├── entity/             # Entités métier (DTO métier)
│   │   ├── exception/          # Gestion des exceptions
│   │   ├── file
│   │   ├── handler
│   │   ├── mail
│   │   ├── repository/         # Accès aux données (JPA)
│   │   ├── service/            # Logique métier
│   └── resources/
│       ├── application.properties
│       └── db/migration/       
└── test/                       # Tests unitaires et d'intégration
    └── java/library/app/com/
        ├── conf/
        ├── endpoint/
        └── db/migration/      

```


---


## Opérations CRUD par entité

| Entité            | GET (liste)        | GET (par ID)            | POST (créer)       | PUT (mettre à jour)     | DELETE                  |
|-------------------|--------------------|-------------------------|--------------------|-------------------------|-------------------------|
| **Book**          | `/books`           | `/books/{id}`           | `/books`           | `/books/{id}`           | `/books/{id}`           |
| **Author**        | `/authors`         | `/authors/{id}`         | `/authors`         | `/authors/{id}`         | `/authors/{id}`         |
| **Publisher**     | `/publishers`      | `/publishers/{id}`      | `/publishers`      | `/publishers/{id}`      | `/publishers/{id}`      |
| **Category**      | `/categories`      | `/categories/{id}`      | `/categories`      | `/categories/{id}`      | `/categories/{id}`      |
| **Edition**       | `/editions`        | `/editions/{id}`        | `/editions`        | `/editions/{id}`        | `/editions/{id}`        |
| **Stock**         | `/stocks`          | `/stocks/{id}`          | `/stocks`          | `/stocks/{id}`          | `/stocks/{id}`          |
| **StockMovement** | `/stock-movements` | `/stock-movements/{id}` | `/stock-movements` | `/stock-movements/{id}` | `/stock-movements/{id}` |
| **Supplier**      | `/suppliers`       | `/suppliers/{id}`       | `/suppliers`       | `/suppliers/{id}`       | `/suppliers/{id}`       |
| **Restocking**    | `/restockings`     | `/restockings/{id}`     | `/restockings`     | `/restockings/{id}`     | `/restockings/{id}`     |
| **Customer**      | `/customers`       | `/customers/{id}`       | `/customers`       | `/customers/{id}`       | `/customers/{id}`       |
| **Order**         | `/orders`          | `/orders/{id}`          | `/orders`          | `/orders/{id}`          | `/orders/{id}`          |
| **OrderLine**     | `/order-lines`     | `/order-lines/{id}`     | `/order-lines`     | `/order-lines/{id}`     | `/order-lines/{id}`     |
| **Cart**          | `/carts`           | `/carts/{id}`           | `/carts`           | `/carts/{id}`           | `/carts/{id}`           |
| **CartItem**      | `/cart-items`      | `/cart-items/{id}`      | `/cart-items`      | `/cart-items/{id}`      | `/cart-items/{id}`      |
| **Payment**       | `/payments`        | `/payments/{id}`        | `/payments`        | `/payments/{id}`        | `/payments/{id}`        |
| **Invoice**       | `/invoices`        | `/invoices/{id}`        | `/invoices`        | `/invoices/{id}`        | `/invoices/{id}`        |
| **Employee**      | `/employees`       | `/employees/{id}`       | `/employees`       | `/employees/{id}`       | `/employees/{id}`       |
| **Review**        | `/reviews`         | `/reviews/{id}`         | `/reviews`         | `/reviews/{id}`         | `/reviews/{id}`         |
| **Promotion**     | `/promotions`      | `/promotions/{id}`      | `/promotions`      | `/promotions/{id}`      | `/promotions/{id}`      |

---

