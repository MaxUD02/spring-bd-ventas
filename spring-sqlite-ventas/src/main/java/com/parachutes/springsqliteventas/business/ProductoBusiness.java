package com.parachutes.springsqliteventas.business;

import com.parachutes.springsqliteventas.model.Producto;
import com.parachutes.springsqliteventas.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoBusiness {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos(){
        return productoRepository.getAllProductos();
    }

    public Producto getProductoByID(int codigoProducto){
        return productoRepository.getProductoById(codigoProducto);
    }

    public int insertProducto(Producto producto){
        return productoRepository.insertProducto(producto);
    }

    public int updateProducto(Producto producto){
        return productoRepository.updateProducto(producto);
    }

    public int deleteProducto(int codigoProducto){
        return productoRepository.deleteProducto(codigoProducto);
    }


}
