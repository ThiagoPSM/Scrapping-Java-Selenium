package com.scrapping.mercadoLibre.client;


import com.scrapping.mercadoLibre.dto.dolarApiDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "dolarApi", url="https://dolarapi.com/")
public interface dolarApi {

    @GetMapping("v1/dolares/blue")
    public dolarApiDto getDolarBlue();

    @GetMapping("v1/dolares/{tipo}")
    public dolarApiDto getDolars(@PathVariable String tipo);
}
