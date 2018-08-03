package com.parachutes.springsqliteventas.controller;

import com.parachutes.springsqliteventas.business.ProductoBusiness;
import com.parachutes.springsqliteventas.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PoductoController {

    @Autowired
    private ProductoBusiness productoBusiness;

    @GetMapping("/producto")
    public List<Producto> getAllProductos(){
        return productoBusiness.getAllProductos();
    }

    @GetMapping("/producto/{codigoProducto}")
    public Producto getProductoById(@PathVariable int codigoProducto){
        return productoBusiness.getProductoByID(codigoProducto);
    }

    @PostMapping("/producto")
    public Producto insertProducto(@RequestBody Producto producto){
        int codigoProducto = productoBusiness.insertProducto(producto);
        producto.setIdProducto(codigoProducto);
        return producto;
    }

    @PutMapping("/producto")
    public Producto updateProducto(@RequestBody Producto producto){
        productoBusiness.updateProducto(producto);
        return producto;
    }

    @DeleteMapping("/producto/{codigoProducto}")
    public Producto deleteProducto(@PathVariable int codigoProducto){
        Producto productoAEliminar = productoBusiness.getProductoByID(codigoProducto);
        productoBusiness.deleteProducto(codigoProducto);
        return productoAEliminar;
    }

}
