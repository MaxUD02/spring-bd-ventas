package com.parachutes.springsqliteventas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private  int idCliente;
    private String nombreCliente;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String dni;

}
