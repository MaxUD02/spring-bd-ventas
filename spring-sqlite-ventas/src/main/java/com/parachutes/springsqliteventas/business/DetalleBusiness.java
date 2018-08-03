package com.parachutes.springsqliteventas.business;

import com.parachutes.springsqliteventas.model.VentaDetalle;
import com.parachutes.springsqliteventas.repository.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleBusiness {

    @Autowired
    private DetalleRepository detalleRepository;

    public List<VentaDetalle> getAllDetalles(){
        return detalleRepository.getAllDetalles();
    }
    public VentaDetalle getDetalleById(int codigoVenta){
        return detalleRepository.getAllDetallesById(codigoVenta);

    }
}
