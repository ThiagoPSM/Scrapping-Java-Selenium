package com.scrapping.mercadoLibre.service;

import com.scrapping.mercadoLibre.model.dolar;

import java.util.List;

public interface IDolarService {
    public dolar valueDolarBlueScrapping() throws InterruptedException;
    public dolar valueDolarBlueFeign();
    public dolar valueDolarsFeign(String tipo);
}
