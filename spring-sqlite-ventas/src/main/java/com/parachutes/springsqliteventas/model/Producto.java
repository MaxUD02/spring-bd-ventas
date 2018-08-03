package com.parachutes.springsqliteventas.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    private int idProducto;
    private String nombreProducto;
    private BigDecimal precioProducto;
}
