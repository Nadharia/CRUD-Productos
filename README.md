

# README - API REST CRUD de Productos con Spring Boot y MySQL

## Descripción

API REST para la gestión de productos, desarrollada con Spring Boot. Permite crear, leer, actualizar y eliminar productos en una base de datos MySQL. Incluye validaciones, manejo centralizado de excepciones personalizadas y documentación automática con Swagger (OpenAPI).

---

## Tecnologías

* **Java 17+**
* **Spring Boot 3.x**
* **Spring Data JPA**
* **MySQL**
* **Spring Validation (Jakarta Validation)**
* **Swagger/OpenAPI (springdoc-openapi)**
* **Maven**

---

## Características principales

* CRUD completo para la entidad Producto
* Paginación para listados (`Pageable`)
* Validación de entradas con anotaciones (`@Valid`)
* Excepciones personalizadas con mensajes y códigos HTTP
* Documentación API con Swagger UI para explorar y probar endpoints
* Respuestas uniformes con DTO personalizado (`ResponseMessage`)
* Controlador REST con convenciones RESTful

---

## Estructura del proyecto

```
src/main/java/com/crud
├── controller           # Controladores REST
├── services            # Lógica de negocio e interfaces
├── repository          # Interfaces JPA para acceso a datos
├── model               # Entidades JPA
├── dto                 # Objetos de transferencia de datos (DTOs)
├── exception           # Manejo personalizado de excepciones
└── config              # Configuraciones (Swagger, seguridad, etc)
```

---

## Configuración

### Base de datos

Configura la conexión a MySQL en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tu_basededatos?useSSL=false&serverTimezone=UTC
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Swagger UI

La documentación queda disponible en:

```
http://localhost:8080/swagger-ui.html
```

---

## Endpoints principales

| Verbo HTTP | Ruta                     | Descripción                      | Request Body      | Respuesta                     |
| ---------- | ------------------------ | -------------------------------- | ----------------- | ----------------------------- |
| GET        | `/productos`             | Listar productos paginados       | No                | `Page<Producto>`              |
| GET        | `/productos/{id}`        | Obtener producto por ID          | No                | `Producto`                    |
| POST       | `/productos/crear`       | Crear un nuevo producto          | `Producto` (JSON) | `ResponseMessage` con mensaje |
| PUT        | `/productos/actualizar`  | Actualizar producto (por nombre) | `Producto` (JSON) | `ResponseMessage` con mensaje |
| DELETE     | `/productos/delete/{id}` | Eliminar producto por ID         | No                | `ResponseMessage` con mensaje |

---

## Ejemplo de uso con curl

Crear un producto:

```bash
curl -X POST "http://localhost:8080/productos/crear" \
-H "Content-Type: application/json" \
-d '{"nombre":"Producto A", "descripcion":"Descripción", "precio":100.0}'
```

Actualizar un producto:

```bash
curl -X PUT "http://localhost:8080/productos/actualizar" \
-H "Content-Type: application/json" \
-d '{"nombre":"Producto A", "descripcion":"Nueva descripción", "precio":150.0}'
```

---

## Manejo de excepciones

* Se usan excepciones personalizadas (`ProductoExcepcion`) con mensaje y código HTTP.
* Un `@ControllerAdvice` global captura estas excepciones y responde con el mensaje y status correspondiente.
* Ejemplos: Producto no encontrado (404), producto existente (409), error interno (500).

---

## Pruebas

### Testing manual

* Usa Swagger UI para probar los endpoints en un entorno gráfico.
* También puedes usar herramientas como Postman o Insomnia.

### Testing automatizado

* Por implementar (recomendado JUnit 5 + Mockito para pruebas unitarias y MockMvc para integración).

---

## Mejoras y próximas funcionalidades

* Implementar seguridad con Spring Security y JWT
* Agregar filtros y ordenamientos en las consultas paginadas
* Añadir logging estructurado para auditoría y debugging
* Implementar pruebas unitarias e integración continua
* Exponer métricas para monitoreo (Spring Actuator)

---

## Cómo contribuir

1. Haz fork del repositorio
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`)
3. Realiza tus cambios y commitea (`git commit -m "Descripción del cambio"`)
4. Haz push a tu fork (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request describiendo tus cambios

---

## Contacto

Joaco — [joakormr@gmail.com](mailto:joakormr@gmail.com)


---




