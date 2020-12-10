# server

## Prerequisites ##

* Java 1.8+
* Maven 3.x
* MySQL 5.7

#Db setup

Configure the db connection in the shopping-cart/modules/server/src/main/resources/application.properties
CREATE DATABASE shopping-cart;

Apply the given scripts in order.

Run shopping-cart/data/initial_data.sql
Run shopping-cart/data/initial_data.sql

## Run the server ##

Go to the shopping-cart/modules/server

`mvn spring-boot:run`