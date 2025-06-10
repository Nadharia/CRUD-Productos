package com.crud.services;





import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.crud.model.Producto;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductoService {




Producto findProducto(Long id);

String createProducto(@Valid Producto producto);

Page<Producto> getAllProductos(Pageable pageable);

String actualizarProducto(Producto producto);

String deleteproducto(Long id);

List<Producto> findAll(Double precio);
}
