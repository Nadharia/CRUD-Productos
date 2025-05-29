package com.crud.exception;

public class ProductoExcepcion extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final int status;

    public ProductoExcepcion(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public static final ProductoExcepcion PRODUCTO_NOT_FOUND =
            new ProductoExcepcion("Producto no encontrado", 404);

    public static final ProductoExcepcion NO_EXISTEN_PRODUCTOS =
            new ProductoExcepcion("No hay una lista de productos", 404);

    public static final ProductoExcepcion ACCESO_DENEGADO =
            new ProductoExcepcion("Acceso denegado", 403);

    public static final ProductoExcepcion NO_SE_PUDO_CREAR =
            new ProductoExcepcion("No se pudo crear el producto", 500);

    public static final ProductoExcepcion PRODUCTO_EXISTENTE =
            new ProductoExcepcion("El producto ya existe", 409); // Cambio a 409 Conflict

    public static final ProductoExcepcion PRODUCTO_INEXISTENTE =
            new ProductoExcepcion("El producto no existe", 404);

    public static final ProductoExcepcion PROBLEMA_AL_ELIMINAR =
            new ProductoExcepcion("No se pudo eliminar el producto", 500); // Cambié a 500, porque 404 es no encontrado, no error al eliminar.
}
