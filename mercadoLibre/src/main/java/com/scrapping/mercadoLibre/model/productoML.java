package com.scrapping.mercadoLibre.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@JsonPropertyOrder({"producto", "precio", "caracteristicas", "vendedor", "valoracion", "comentarios"})
public class productoML {
    private String Producto;
    private String precio;
    private List<String> caracteristicas;
    private String vendedor;
    private String valoracion;
    private List<String> comentarios;
}
