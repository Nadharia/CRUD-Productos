package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crud.dto.ResponseMessage;
import com.crud.model.Producto;
import com.crud.services.IProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/productos")
@Tag(name = "Productos", description = "Operaciones con productos")
public class ProductoController {
	
	@Autowired
	private IProductoService iproductoService;

	@Operation(summary = "Obtener listado de productos", responses = {
		@ApiResponse(responseCode = "200", description = "Listado encontrado"),
		@ApiResponse(responseCode = "404", description = "Lista inexistente")
	})
	@GetMapping
	public Page<Producto> AllProductos(Pageable pageable) {
		return iproductoService.getAllProductos(pageable);
	}
	
	@Operation(summary = "Obtener un producto por id", responses = {
			@ApiResponse(responseCode = "200", description = "Producto encontrado"),
			@ApiResponse(responseCode = "404", description = "No existe el producto")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Producto> findProducto(@PathVariable Long id) {
		Producto producto = iproductoService.findProducto(id);
		return ResponseEntity.ok(producto);
	}
	
	@Operation(summary = "Crear un nuevo producto", responses = {
		@ApiResponse(responseCode = "201", description = "Producto creado exitosamente"),
		@ApiResponse(responseCode = "400", description = "Datos inválidos o producto existente")
	})
	@PostMapping("/crear")
	public ResponseEntity<ResponseMessage> createProducto(@RequestBody @Valid Producto producto){
		String mensaje = iproductoService.createProducto(producto);
		ResponseMessage response = new ResponseMessage();
		response.setMensaje(mensaje);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@Operation(summary = "Actualizar un producto existente", responses = {
		@ApiResponse(responseCode = "202", description = "Producto actualizado"),
		@ApiResponse(responseCode = "404", description = "Producto no encontrado"),
		@ApiResponse(responseCode = "400", description = "Datos inválidos")
	})
	@PutMapping("/actualizar")
	public ResponseEntity<ResponseMessage> actualizarProducto(@RequestBody @Valid Producto producto){
		String mensaje = iproductoService.actualizarProducto(producto);
		ResponseMessage response = new ResponseMessage();
		response.setMensaje(mensaje);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	@Operation(summary = "Eliminar un producto por id", responses = {
		@ApiResponse(responseCode = "202", description = "Producto eliminado"),
		@ApiResponse(responseCode = "404", description = "Producto no encontrado")
	})
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteProducto(@PathVariable Long id){
		String mensaje = iproductoService.deleteproducto(id);
		ResponseMessage response = new ResponseMessage();
		response.setMensaje(mensaje);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	@GetMapping("/buscarproducto")
	public ResponseEntity<List<Producto>> findByPrecioMenor(@RequestParam Double precio){
		List<Producto> listProductos=iproductoService.findAll(precio);
		return ResponseEntity.ok(listProductos);
	}
}
