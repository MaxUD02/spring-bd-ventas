package com.parachutes.springsqliteventas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

    private BigDecimal importeTotal;
    private Cliente cliente;
    private List<VentaDetalle> detalleList;
}
