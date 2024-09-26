package com.scrapping.mercadoLibre.service;

import com.scrapping.mercadoLibre.client.dolarApi;
import com.scrapping.mercadoLibre.dto.dolarApiDto;
import com.scrapping.mercadoLibre.model.dolar;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
@Service
@AllArgsConstructor
public class dolarService implements IDolarService{
    private final String url = "https://dolarhoy.com";
    private final ChromeDriver driver;

    @Autowired
    private dolarApi dApi;


    @Override
    public dolar valueDolarBlueScrapping() throws InterruptedException {

        try{
            driver.get(url);
            dolar dBlue = new dolar();

            Thread.sleep(2000);

            WebElement compra = driver.findElement(By.xpath("//div[@class='tile is-child']/div[@class='values']/div[@class='compra']/div[@class='val']"));
            WebElement venta = driver.findElement(By.xpath("//div[@class='tile is-child']/div[@class='values']/div[@class='venta']/div[@class='val']"));


            dBlue.setCompra(compra.getText());
            dBlue.setVenta(venta.getText());

            return dBlue;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            driver.quit();
        }
    }

    @Override
    public dolar valueDolarBlueFeign() {
        dolarApiDto dolardto = dApi.getDolarBlue();
        dolar dolarBlue = new dolar(dolardto.getCompra().toString(), dolardto.getVenta().toString());
        return dolarBlue;
    }

    @Override
    public dolar valueDolarsFeign(String tipo) {
        dolarApiDto dolardto = dApi.getDolars(tipo);
        dolar dolarBlue = new dolar(dolardto.getCompra().toString(), dolardto.getVenta().toString());
        return dolarBlue;
    }
}
