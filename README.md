
# Cabinet Médical – Architecture SOA avec ESB (Apache Camel)

## Description

Ce projet a été réalisé dans le cadre du **TP2 – Systèmes Distribués Basés sur les Microservices**
*(Master IPS – FSR)*.

L’objectif principal est de **refactoriser une application monolithique de gestion d’un cabinet médical** vers une **architecture orientée services (SOA)**.
L’architecture repose sur un **ESB Apache Camel**, utilisé comme **point d’entrée unique** pour toutes les requêtes externes.

Chaque fonctionnalité métier est exposée sous forme d’un service indépendant, tandis que l’ESB se charge du **routage**, de la **centralisation des accès** et de la **découplage entre les services**.

---

## Architecture générale

Le projet est structuré sous forme d’un **projet Maven multi-modules**, composé des éléments suivants :

### 1. `cabinet-esb`

* ESB basé sur **Apache Camel**
* Point d’entrée unique pour les clients externes
* Expose les APIs publiques sous `/api/**`
* Redirige les requêtes vers les services métiers appropriés

### 2. `cabinet-repo`

* Module de données partagées
* Contient :

    * Les entités JPA
    * Les repositories Spring Data JPA
* Ne contient **aucune logique métier**

### 3. Services métiers

Chaque service représente une fonctionnalité bien définie :

* `patient-service-api` : gestion des patients
* `medecin-service-api` : gestion des médecins
* `rendezvous-service-api` : gestion des rendez-vous
* `consultation-service-api` : gestion des consultations

> ⚠️ **Les services ne communiquent jamais directement entre eux.**
> Toute requête externe passe obligatoirement par l’ESB, qui joue le rôle d’intermédiaire.

---

## Technologies utilisées

* Java 21
* Spring Boot
* Spring Data JPA
* Apache Camel
* Maven (multi-modules)
* Base de données H2 (en mémoire)

---

## Ports utilisés

| Module               | Port |
| -------------------- | ---- |
| ESB (`cabinet-esb`)  | 8080 |
| Patient Service      | 8082 |
| Médecin Service      | 8083 |
| Rendez-vous Service  | 8084 |
| Consultation Service | 8085 |

---

## Accès aux APIs

Toutes les requêtes passent par l’ESB via le port **8080**.

### Exemple – Gestion des patients

* `GET /api/patients` → Récupérer la liste des patients
* `GET /api/patients/{id}` → Récupérer un patient par son identifiant
* `POST /api/patients` → Ajouter un nouveau patient
* `PUT /api/patients/{id}` → Modifier un patient existant
* `DELETE /api/patients/{id}` → Supprimer un patient

---

Si tu veux, je peux aussi te fournir :

* une **version encore plus académique**
* une **version plus courte**
* ou un README avec une section **Lancement du projet & tests Postman**
