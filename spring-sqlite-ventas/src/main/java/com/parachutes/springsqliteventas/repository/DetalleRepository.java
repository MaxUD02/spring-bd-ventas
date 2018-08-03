package com.parachutes.springsqliteventas.repository;

import com.parachutes.springsqliteventas.model.VentaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DetalleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VentaDetalle> getAllDetalles(){
        String sql = "SELECT C_CODIGO_VENTA, C_CODIGO_PRODUCTO, C_PRECIO_UNITARIO, C_CANTIDAD, (C_PRECIO_UNITARIO * C_CANTIDAD) AS SUBTOTAL FROM T_VENTA_DETALLE";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            VentaDetalle ventaDetalle = new VentaDetalle();
            ventaDetalle.setIdVenta(rs.getInt("C_CODIGO_VENTA"));
            ventaDetalle.setIdProducto(rs.getInt("C_CODIGO_PRODUCTO"));
            ventaDetalle.setPrecioUnitario(rs.getBigDecimal("C_PRECIO_UNITARIO"));
            ventaDetalle.setCantidad(rs.getInt("C_CANTIDAD"));
            ventaDetalle.setSubTotal(rs.getBigDecimal("SUBTOTAL"));
            return ventaDetalle;
        });
    }

    public VentaDetalle getAllDetallesById(int codigoVenta){
        String sql = "SELECT C_CODIGO_VENTA, C_CODIGO_PRODUCTO, C_PRECIO_UNITARIO, C_CANTIDAD, (C_PRECIO_UNITARIO * C_CANTIDAD) AS SUBTOTAL FROM T_VENTA_DETALLE WHERE C_CODIGO_VENTA=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            VentaDetalle ventaDetalle = new VentaDetalle();
            ventaDetalle.setIdVenta(rs.getInt("C_CODIGO_VENTA"));
            ventaDetalle.setIdProducto(rs.getInt("C_CODIGO_PRODUCTO"));
            ventaDetalle.setPrecioUnitario(rs.getBigDecimal("C_PRECIO_UNITARIO"));
            ventaDetalle.setCantidad(rs.getInt("C_CANTIDAD"));
            ventaDetalle.setSubTotal(rs.getBigDecimal("SUBTOTAL"));
            return ventaDetalle;
        }, codigoVenta);
    }
}
