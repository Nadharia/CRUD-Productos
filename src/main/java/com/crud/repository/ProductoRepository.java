package com.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.crud.model.Producto;




@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long>, JpaSpecificationExecutor<Producto> {

	

	Optional<Producto> findByNombre(String nombre);

}
