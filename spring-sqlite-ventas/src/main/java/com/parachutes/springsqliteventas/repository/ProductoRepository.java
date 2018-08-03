package com.parachutes.springsqliteventas.repository;


import com.parachutes.springsqliteventas.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Producto> getAllProductos(){
        String sql = "SELECT C_CODIGO_PRODUCTO, C_NOMBRE_PRODUCTO, C_PRECIO_BASE FROM T_PRODUCTO";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Producto producto = new Producto();
            producto.setIdProducto(rs.getInt("C_CODIGO_PRODUCTO"));
            producto.setNombreProducto(rs.getString("C_NOMBRE_PRODUCTO"));
            producto.setPrecioProducto(rs.getBigDecimal("C_PRECIO_BASE"));
            return producto;
        }) ;
    }

    public Producto getProductoById(int codigoProducto){
        String sql = "SELECT C_CODIGO_PRODUCTO, C_NOMBRE_PRODUCTO, C_PRECIO_BASE FROM T_PRODUCTO WHERE C_CODIGO_PRODUCTO =?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Producto producto = new Producto();
            producto.setIdProducto(rs.getInt("C_CODIGO_PRODUCTO"));
            producto.setNombreProducto(rs.getString("C_NOMBRE_PRODUCTO"));
            producto.setPrecioProducto(rs.getBigDecimal("C_PRECIO_BASE"));
            return producto;
        }, codigoProducto);
    }

    private int getNextId(){
        String sql = "SELECT MAX(C_CODIGO_PRODUCTO)+1 FROM T_PRODUCTO";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public int insertProducto(Producto producto){
        String sql="INSERT INTO T_PRODUCTO(C_CODIGO_PRODUCTO, C_NOMBRE_PRODUCTO, C_PRECIO_BASE) VALUES(?,?,?)";
        int newId = getNextId();
        jdbcTemplate.update(sql, newId, producto.getNombreProducto(),producto.getPrecioProducto());
        return newId;
    }

    public int updateProducto(Producto producto){
        String sql = "UPDATE T_PRODUCTO SET C_NOMBRE_PRODUCTO =?, C_PRECIO_BASE=? WHERE C_CODIGO_PRODUCTO = ?";
        return jdbcTemplate.update(sql, producto.getNombreProducto(), producto.getPrecioProducto(), producto.getIdProducto());
    }

    public int deleteProducto(int codigoProducto){
        String sql="DELETE FROM T_PRODUCTO WHERE C_CODIGO_PRODUCTO=?";
        return jdbcTemplate.update(sql, codigoProducto);
    }
}
