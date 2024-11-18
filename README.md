# IPWA2-01 - Programmierung von industriellen Informationssystemen mit Java EE

## Einleitung

Dieses Projekt wurde im Rahmen einer Fallstudie der IU - Interhantionale Hochschule erstellt und entwickelt.

## Setup

Die Fallstudie wurde mit IntelliJ von JetBrains entwickelt. Als Server wurde ein Tomcat 10.1.31 genutzt. Als SDK wurde Java
23.0.1 verwendet.

Als Datenbank wurde eine MariaDB in einem Docker-Container genutzt. Das Setup dazu ist
im [docker-compose](docker-compose.yaml) einzusehen. Der nötige Datenimport ist im [database_dump](database_dump.sql) zu
finden. Dort wird sowohl die Datenbank als auch alle Tabellen erstellt und mit Daten befüllt. Darunter befinden sich
einige User und ein Admin user. Bei der erstellung wird das Passwort mit "password" entsprechend belegt um händisch
Tests ausführen zu können.