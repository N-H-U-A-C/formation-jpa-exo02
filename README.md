## JPA Exo 02 (Billetterie)

Créer une application permettant de gérer une billeterie.

#### Classes à définir :

- Adresse
  - rue
  - ville
  - adresse a une relation oneToOne avec client et événement
- Billet :
  - numéro de place
  - client
  - événement
  - type de place (standard, gold, vip)
- Evénement :
  - nom
  - adresse
  - date
  - heure
  - nombre de place
- Client :
  - nom
  - prénom
  - adresse
  - âge
  - numéros de telephone

---

#### Méthodes à définir :

1. Réservation de billets :
    - les clients peuvent réserver des billets pour différents événements, chaque billet est lié à un événement.

2. Gestion des événements :
    - pour un événement, il est possible de récupérer la liste de ses billets.

3. Interface homme-machine (IHM) :
    - depuis l'ihm, il est possible de réaliser les opérations CRUD pour chaque entité.

4. (Bonus) Vérification des places disponibles :
    - lors de la réservation d'un billet, il est possible de vérifier si l'événement a encore des places disponibles.