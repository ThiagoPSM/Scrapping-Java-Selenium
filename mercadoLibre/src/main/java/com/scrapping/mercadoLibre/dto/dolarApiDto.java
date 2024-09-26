package com.scrapping.mercadoLibre.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class dolarApiDto {
    private Number compra;
    private Number venta;
    private String casa;
    private String nombre;
    private String moneda;
    private String fechaActualizacion;
}
