# api
apiSuperheroes

Para abrir el H2 

* Driver Class:	org.h2.Driver
* JDBC URL:	jdbc:h2:mem:~/superhero
* User Name: sa
* Password:	

* http://localhost:8000/h2

Buscar por Id
http://localhost:8000/api/superheroes/hero/2

Modificar Heroe
http://localhost:8000/api/superheroes/heroupdate/1

{
"name":"man"
"alter":"patito"
}

Buscar por partes del nombre
http://localhost:8000/api/superheroes/hero/search?name=man

Eliminar por Id
http://localhost:8000/api/superheroes/delete/1

Ejecutar docker (En la raiz del proyecto, abrir consola y escribir):
docker build -t superheroes-api .

Luego escribir:
docker run -it --rm -p 8000:8000 superheroes-api

Para abrir Swagger 
http://localhost:8000/swagger-ui.html

Para corroborar el cache, se puede realizar una busqueda de un elemento por id, 
luego modificar ese elemento, lo cual seguira trayendo la antigua informacion del heroe, pero si buscamos todos traera la nueva informacion,
eliminamos el cache eliminando ese heroe.

El timed esta demarcado en el log como este ejemplo 
* Method updateSuperhero executed in 54 ms
* Method getSuperheroById executed in 1 ms
* Method getSuperheroById executed in 1 ms
* Method getAllSuperheroes executed in 37 ms


