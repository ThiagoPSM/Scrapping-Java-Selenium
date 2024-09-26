package com.scrapping.mercadoLibre.service;

import com.scrapping.mercadoLibre.model.productoML;

import java.util.List;

public interface IProductoMLService {
    public List<productoML> obtenerProducto(String producto, int cantidad);
}
