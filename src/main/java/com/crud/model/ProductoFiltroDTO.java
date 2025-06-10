package com.crud.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoFiltroDTO {
    private String nombre;
    private Double precioMin;
    private Double precioMax;
    private Integer stockMin;
    private Integer stockMax;
}