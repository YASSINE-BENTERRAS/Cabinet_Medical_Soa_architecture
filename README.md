Cabinet Medical – Architecture SOA avec ESB (Apache Camel)
Description

Ce projet est réalisé dans le cadre du TP2 – Systèmes Distribués Basés sur les Microservices (Master IPS – FSR).
L’objectif est de transformer une application monolithique de gestion d’un cabinet médical en une architecture orientée services (SOA), avec un ESB Apache Camel comme point d’entrée unique.

Chaque fonctionnalité métier est isolée dans un service indépendant, tandis que l’ESB assure le routage des requêtes externes vers les services internes.

Architecture générale

Le projet est organisé sous forme d’un projet Maven multi-modules :

cabinet-esb
ESB Apache Camel

Point d’entrée unique pour les clients

Expose les APIs publiques /api/**

Redirige les requêtes vers les services internes

cabinet-repo
Module de données partagées

Entités JPA

Repositories Spring Data JPA

Aucune logique métier

patient-service-api
Gestion des patients

medecin-service-api
Gestion des médecins

rendezvous-service-api
Gestion des rendez-vous

consultation-service-api
Gestion des consultations

👉 Les services ne communiquent jamais directement entre eux.
Toute requête externe passe obligatoirement par l’ESB.

Technologies utilisées

Java 21

Spring Boot

Spring Data JPA

Apache Camel

Maven (multi-modules)

Base de données H2 (en mémoire)

Ports utilisés
Module	Port
ESB (cabinet-esb)	8080
Patient Service	8082
Médecin Service	8083
Rendez-vous Service	8084
Consultation Service	8085
Accès aux APIs
Exemple – Patients

GET /api/patients → Liste des patients

GET /api/patients/{id} → Patient par id

POST /api/patients → Ajouter un patient

PUT /api/patients/{id} → Modifier un patient

DELETE /api/patients/{id} → Supprimer un patient