package com.parachutes.springsqliteventas.controller;


import com.parachutes.springsqliteventas.business.DetalleBusiness;
import com.parachutes.springsqliteventas.model.Cliente;
import com.parachutes.springsqliteventas.model.VentaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DetalleController {

    @Autowired
    private DetalleBusiness detalleBusiness;

    @GetMapping("/detalle")
    public List<VentaDetalle> getAllDetalles(){
        return detalleBusiness.getAllDetalles();
    }
    @GetMapping("/detalle/{codigoVenta}")
    public VentaDetalle getDetalleById(@PathVariable int codigoVenta){
        return detalleBusiness.getDetalleById(codigoVenta);
    }
}
