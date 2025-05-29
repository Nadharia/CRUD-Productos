README - API CRUD de Productos con Spring Boot
Descripción
Esta es una API REST desarrollada con Spring Boot para gestionar productos almacenados en una base de datos MySQL.
Incluye paginación, validación, manejo de excepciones personalizadas, y documentación con Swagger/OpenAPI.

Tecnologías utilizadas
Java 17+

Spring Boot

Spring Data JPA

MySQL

Swagger/OpenAPI (springdoc-openapi)

Maven

Jakarta Validation (@Valid)

Funcionalidades
Listar productos con paginación

Obtener un producto por su ID

Crear un nuevo producto

Actualizar un producto existente (búsqueda por nombre)

Eliminar un producto por ID

Manejo centralizado de excepciones personalizadas con mensajes y códigos HTTP

Documentación API con Swagger UI

Endpoints
Método	URL	Descripción
GET	/productos	Listar todos los productos paginados
GET	/productos/{id}	Obtener un producto por ID
POST	/productos/crear	Crear un nuevo producto
PUT	/productos/actualizar	Actualizar un producto (por nombre)
DELETE	/productos/delete/{id}	Eliminar un producto por ID

Cómo ejecutar el proyecto
Clona el repositorio:

bash
Copiar
Editar
git clone <URL-del-proyecto>
Configura la conexión a MySQL en application.properties:

properties
Copiar
Editar
spring.datasource.url=jdbc:mysql://localhost:3306/tu_basededatos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
Ejecuta la aplicación desde tu IDE o con Maven:

bash
Copiar
Editar
mvn spring-boot:run
Accede a Swagger UI para explorar la API:

bash
Copiar
Editar
http://localhost:8080/swagger-ui.html
Estructura del proyecto
controller → Controladores REST

services → Servicios con la lógica de negocio

repository → Interfaces JPA para acceso a datos

model → Entidades JPA

exception → Clases para manejo de excepciones personalizadas

dto → Clases para respuestas personalizadas (ej: ResponseMessage)

Manejo de excepciones
Las excepciones personalizadas extienden RuntimeException y tienen un código HTTP asociado para facilitar respuestas coherentes.
Un @ControllerAdvice global (no incluido aquí) puede capturar estas excepciones y devolver la respuesta adecuada al cliente.

Mejoras futuras

Tests unitarios y de integración

Contacto
Para dudas o sugerencias, contacta a:
Joaco- - joakormr@ejemplo.com
