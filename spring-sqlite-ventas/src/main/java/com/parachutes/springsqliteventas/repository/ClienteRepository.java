package com.parachutes.springsqliteventas.repository;


import com.parachutes.springsqliteventas.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cliente> getAllClientes(){
        String sql="SELECT *FROM T_CLIENTE";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
           Cliente cliente = new Cliente();
           cliente.setIdCliente(rs.getInt("C_CODIGO_CLIENTE"));
           cliente.setNombreCliente(rs.getString("C_NOMBRE_CLIENTE"));
           cliente.setApellidoPaterno(rs.getString("C_APELLIDO_PATERNO_CLIENTE"));
           cliente.setApellidoMaterno(rs.getString("C_APELLIDO_MATERNO_CLIENTE"));
           cliente.setDni(rs.getString("C_NUMERO_DOCUMENTO"));
           return cliente;
        });
    }

    public Cliente getClienteById(int codigoCliente){
        String sql="SELECT * FROM T_CLIENTE WHERE C_CODIGO_CLIENTE=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("C_CODIGO_CLIENTE"));
            cliente.setNombreCliente(rs.getString("C_NOMBRE_CLIENTE"));
            cliente.setApellidoPaterno(rs.getString("C_APELLIDO_PATERNO_CLIENTE"));
            cliente.setApellidoMaterno(rs.getString("C_APELLIDO_MATERNO_CLIENTE"));
            cliente.setDni(rs.getString("C_NUMERO_DOCUMENTO"));
            return cliente;
        }, codigoCliente);
    }

    private int getNextId(){
        String sql = "SELECT MAX(C_CODIGO_CLIENTE) +1 FROM T_CLIENTE";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public int insertCliente(Cliente cliente){
        String sql =" INSERT INTO T_CLIENTE(C_CODIGO_CLIENTE, C_NOMBRE_CLIENTE, C_APELLIDO_PATERNO_CLIENTE, C_APELLIDO_MATERNO_CLIENTE, C_NUMERO_DOCUMENTO) " +
                "VALUES(?,?,?,?,?)";
        int newId = getNextId();
        jdbcTemplate.update(sql, newId, cliente.getNombreCliente(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getDni());
        return newId;
    }

    public int updateCliente(Cliente cliente){
        String sql = "UPDATE T_CLIENTE SET C_NOMBRE_CLIENTE=?, C_APELLIDO_PATERNO_CLIENTE=?, C_APELLIDO_MATERNO_CLIENTE=?,C_NUMERO_DOCUMENTO=?" +
                "WHERE C_CODIGO_CLIENTE = ?";
        return jdbcTemplate.update(sql, cliente.getNombreCliente(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getDni(), cliente.getIdCliente());
    }

    public int deleteCliente(int codigoCliente){
        String sql = "DELETE FROM T_CLIENTE WHERE C_CODIGO_CLIENTE=?";
        return jdbcTemplate.update(sql, codigoCliente);
    }
}
