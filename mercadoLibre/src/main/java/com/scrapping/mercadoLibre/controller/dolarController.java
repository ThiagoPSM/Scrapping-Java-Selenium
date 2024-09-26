package com.scrapping.mercadoLibre.controller;

import com.scrapping.mercadoLibre.model.dolar;
import com.scrapping.mercadoLibre.service.IDolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Dolar")
public class dolarController {

    @Autowired
    private IDolarService dolServ;

    @GetMapping("/Scrapping")
    public dolar getValueDolarScrapping() throws InterruptedException {
        return dolServ.valueDolarBlueScrapping();
    }

    @GetMapping("/Api")
    public dolar getValueDolarFeign(){
        return dolServ.valueDolarBlueFeign();
    }

    @GetMapping("/Api/{tipo}")
    public dolar getValueDolarsFeign(@PathVariable String tipo){
        return dolServ.valueDolarsFeign(tipo);
    }

}
