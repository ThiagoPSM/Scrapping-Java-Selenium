package com.scrapping.mercadoLibre.config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeleniumConfig {
/*
    @PostConstruct
    void postConstruct(){
        String path = System.getProperty("user.dir");
                                                              //\\Users\\Thiago\\Desktop\\Pruebas Scrapping\\chromedriver-win64
        System.setProperty("webdriver.chrome.driver", path + "\\Desktop\\Pruebas Scrapping\\chromedriver-win64");
    }
*/

    @Bean
    public ChromeDriver driver(){
        final ChromeOptions options = new ChromeOptions();
        //para que no se muestre la ventana de chrome
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }


}
