# McDonalds Projekt Backend

Das ist das Backend zu dem McDonalds Projekt an dem wir gerade arbeiten. Die erste Version ist in den Befehlen sehr beschränkt, da sie erstmal nur da ist, um alle grundlegenden Mechaniken zu testen. Die erste Version kann 4 HTTP Request handeln:
* GET
```cmd
http://localhost:8080/
```
* POST
```cmd
POST http://localhost:8080/new_order
Content-Type: application/json

{
    "product":"Test 2"
}
```
* PUT
```cmd
PUT http://localhost:8080/edit/1

Test 4
```
* DELETE
```cmd
DELETE http://localhost:8080/1
```
