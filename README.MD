## Primer paso para conectar

Se añadio unas librerias para poder conectar con postgres, en el caso presente se conectar con un contenedor en docker en el puerto 5050.

Para crear ese conectenedor se uso el siguiente comando

```terminal
sudo docker run --name postgresCapas2 -p 5050:5432 -e POSTGRES_PASSWORD=capasproyecto -d postgres 
```
### Añadimos librerias
Podemos agregarla desde el inicio de nuestro proyecto o directamente en el gradle.
> Las librerias a agregar son:
>* Lombok
>* Spring web
>* Mustache
>* JDBC API
>* Spring Data JPA
>* PostgreSQL Driver
>* Validation

### Conectando
Nos dirijimos a al archivo `Application.properties`, en ese archivo escriviremos nuestras credenciales, como en el siguiente ejemplo:
```java
spring.datasource.url=jdbc:postgresql://localhost:5050/db_citysecurity

spring.datasource.username=postgres
spring.datasource.password=capasproyecto

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.globally_quoted_identifiers=true
```
Colocamos nuestras credenciales, asi como en la primera linea que hacemos referencia al puerto que se conectara junto con la base de datos.
Corremos el programa y no tendria que dar error, en caso de error comprueve todos los pasos anteriores.

:tada: Una vez conectado comenzamos a hacer nuestras cosultas

>Primero crearemos una estructura de carpetas

> Dentro de la carpeta
> * src 
>   * main
>     * java 
>       * com.nombre_proyecto

Creamos lo siguiente estructura
> * controllers
> * models
>   * dtos
>   * entities
> * repository
> * services
>   *  servicesImple
>   *  service.java

Comenzamos con la carpeta entities, que significa entidades, referencia a nuestra base de datos, las entidades de
nuestra base de datos

Para ejemplo practico crearemos una tabla user,
creamos un archivo.java, en este caso sera User.java

Escrivimos el siguiente codigo:

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    // el archivo de la base de datos se llama users
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private String id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="email")
    private String gmail;

    @JsonIgnore //para que no se muestre en la password
    @Column(name="password")
    private String password;

    @Column(name="rol")
    private String rol;

    @Column(name="fecha_contratacion")
    private Date fecha_contratacion;

}
```

Despues vamos a nuestro archivo repository y creamos un archivo que sera el **REPOSITORIO** de User, le llamaremos `UserRepository`, 
y tambien el archivo encargado de conectar con la base de datos, en el cual le paremos todas las consultas, desde cualquier archivo
pero por seguridad seguiremos una estructura especifica a futuro que seria

> [!IMPORTANT]
>*Controlador* **-->** *Services* **-->** *Repository*

Dentro de nuestro archivo user `UserRepository` escrivimos el siguiente codigo:
```java
public interface UserRepositoy extends JpaRepository<User, String> {
//Aqui puede ir los metodos a implementar como un service
//Igualmente se puede dejar vacio    
}
```
Para terminar vamos a nuesta carpeta **controllers**, creamos un archivo llamado `UserController`,
dentro del archivo pegamos le siguiente comando:

```java
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserRepositoy userRepositoy;

    @PostMapping("/adduser")
    public void addUser(@RequestBody User user) {
        userRepositoy.save(user);
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepositoy.findAll();
    }

}
```

Unaves allamos escrito todo ya podremos hacer una peticion, para ello podemos usar `Postman` o tambien `Insomnia`,
en caso no se pueda contar con ninguna de esas herramienta podemos hacer consultas con el conpilador que este usando.

> [!NOTE]
>Para mayor organizacion podemos crear una capeta llamada `Requests` y escrivimos nuestro **achivo.http**,
> un ejemplo seria `AddUser.hppt`

Creamos nuestar peticion dentro del archivo, en este caso para creaer un usuario:
 ```http request
 POST http://localhost:8080/api/adduser HTTP/1.1
Content-Type: application/json

{
  "nombre": "Macdanela",
  "apellido": "Gonzalez",
  "gmail":"MacSemi43@gmail.com",
  "password":"megustaelpandulce",
  "rol": "Admin",
  "fecha_contratacion": "2021-09-01"
}
 ```
> [!IMPORTANT]
>Si en caso da error revisar bien los campos que estamos ingresando sean los mismos que la base de datos



