# techShop
Test REST project of tech.Shop

Application represents a simple REST web service that provide data regarding phone in a tech.shop. Data is stored in MySQL.

***
REST resource is accessible by:

"/techshop/phone/ph"  to GET Phone by title;

"/techshop/phone/all" to GET all Phones;

"/techshop/phone"  for POST, DELETE and PUT;

For PUT and DELETE methods you have to specify the id.

Example: "/techshop/phone/1"

***

JSON data for POST/PUT methods:

```Java
{
"id":"1",
"title":"Galaxxy G6+",
"manufacturer":"Samsung",
"status":"AVAILABLE",
"material":"STEEL",
"price":"999.99",
"digital":"true"
}

```
