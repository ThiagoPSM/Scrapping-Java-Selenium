package com.scrapping.mercadoLibre.controller;

import com.scrapping.mercadoLibre.model.productoML;
import com.scrapping.mercadoLibre.service.IProductoMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/MercadoLibre")
public class productoMLController {

    @Autowired
    private IProductoMLService prodML;

    @GetMapping("/producto/{nombreProducto}/{cantidadBusquedas}")
    public List<productoML> obtenerProducto(@PathVariable String nombreProducto, @PathVariable int cantidadBusquedas){
        return prodML.obtenerProducto(nombreProducto, cantidadBusquedas);
    }
}
