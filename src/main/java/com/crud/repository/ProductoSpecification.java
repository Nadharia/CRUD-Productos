package com.crud.repository;

import com.crud.model.Producto;
import com.crud.model.ProductoFiltroDTO;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

public class ProductoSpecification {

public static Specification<Producto> conFiltros(ProductoFiltroDTO productoFiltroDTO){
    return((root, query, criteriaBuilder) -> {
        List<Predicate> predicates=new ArrayList<>();

        if(productoFiltroDTO.getNombre()!=null){
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")), "%"+productoFiltroDTO.getNombre().toLowerCase()+"%"));

        }

        if (productoFiltroDTO.getPrecioMax()!=null){
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("precio"),productoFiltroDTO.getPrecioMax()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    });
}

}
