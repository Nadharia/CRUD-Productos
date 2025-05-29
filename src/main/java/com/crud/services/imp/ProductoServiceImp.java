package com.crud.services.imp;



import org.springframework.data.domain.Page;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.crud.exception.ProductoExcepcion;
import com.crud.model.Producto;
import com.crud.repository.ProductoRepository;
import com.crud.services.IProductoService;




@Service

public class ProductoServiceImp implements IProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public Page<Producto> getAllProductos(Pageable pageable) {
		Page<Producto> listado=productoRepository.findAll(pageable);
			if (listado.isEmpty())throw ProductoExcepcion.NO_EXISTEN_PRODUCTOS;
				return listado;
			
	}
	
	@Override
	public Producto findProducto(Long id) {
		return productoRepository.findById(id)
			    .orElseThrow(() -> ProductoExcepcion.PRODUCTO_NOT_FOUND);
		
	}

	@Override
	public String createProducto(Producto producto) {
		
		Optional<Producto> productoYaExistente=productoRepository.findByNombre(producto.getNombre());
		
		if (productoYaExistente.isPresent())throw ProductoExcepcion.PRODUCTO_EXISTENTE;
		
		productoRepository.save(producto);
		
		return "Producto creado";
		
		
	}

	@Override
	public String actualizarProducto(Producto producto) {
		Optional<Producto> productoOpt=productoRepository.findByNombre(producto.getNombre());
		if (!productoOpt.isPresent())throw ProductoExcepcion.PRODUCTO_INEXISTENTE;

		Producto productoPresente=productoOpt.get();

		productoPresente.setNombre(producto.getNombre());
		productoPresente.setPrecio(producto.getPrecio());
		productoPresente.setStock(producto.getStock());
		productoPresente.setDescripcion(producto.getDescripcion());

		productoRepository.save(productoPresente);
		return "producto actualizado";
	}

	@Override
	public String deleteproducto(Long id) {
		try {
			productoRepository.deleteById(id);
			return "Se borro el producto";
		} catch (ProductoExcepcion e) {
			throw ProductoExcepcion.PROBLEMA_AL_ELIMINAR;
		}
	}

}
