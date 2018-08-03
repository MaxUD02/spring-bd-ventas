package com.parachutes.springsqliteventas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaDetalle {

    private int idVenta;
    private int idProducto;
    private BigDecimal precioUnitario;
    private int cantidad;
    private BigDecimal subTotal;
}
