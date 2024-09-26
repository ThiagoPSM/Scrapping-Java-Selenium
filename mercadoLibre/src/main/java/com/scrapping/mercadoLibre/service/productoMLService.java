package com.scrapping.mercadoLibre.service;

import com.scrapping.mercadoLibre.model.productoML;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class productoMLService implements IProductoMLService {
    final String url = "https://www.mercadolibre.com.ar";
    private final ChromeDriver driver;


    @Override
    public List<productoML> obtenerProducto(String producto, int cantidad) {
        driver.get(url);
        WebElement buscadorML = driver.findElement(By.xpath("//input[@name='as_word']"));
        buscadorML.sendKeys(producto);
        buscadorML.submit();

        List<String> uris = obtenerUriArticulos(driver, cantidad);
        return obtenerDatosArticulos(uris, driver);
    }

    private static List<String> obtenerUriArticulos(WebDriver driver, int cantidad){
        final By xPathUri = By.xpath("//ol/li/div/div/div/h2/a[starts-with(@href, 'https://')]");
        List<String> urisProd = new ArrayList<>();
        List<WebElement> uris = driver.findElements(xPathUri);

        int contador = 0;
        for (WebElement articulos: uris) {
            if(contador == cantidad){
                break;
            }
            urisProd.add(articulos.getAttribute("href"));
            contador++;
        }
        System.out.println("hasta aca llego 2");
        return urisProd;
    }

    private static List<productoML> obtenerDatosArticulos(List<String> uris, WebDriver driver){
        List<productoML> productos = new ArrayList<>();
        System.out.println("hasta aca llego 3");
        for(String url: uris){
            productoML prod = new productoML();
            driver.get(url);

            //primero obtener nombre del articulo
            WebElement nombreArt= driver.findElement(By.xpath("//h1[@class='ui-pdp-title']"));
            prod.setProducto(nombreArt.getText());
            System.out.println("nombre");


            //segundo obtener el precio precio
            WebElement precioArt= driver.findElement(By.xpath("//span[@class='andes-money-amount__fraction']"));
            prod.setPrecio(precioArt.getText());
            System.out.println("precio");

            //tercero obtener algunos datos del producto (en lo posible).
            List<WebElement> datosArt= driver.findElements(By.xpath("//li[starts-with(@class, 'ui-vpp-highlighted-specs__features-list-item')]"));
            List<String> datosProd = new ArrayList<>();

            datosArt.forEach(datos -> datosProd.add(datos.getText()));
            prod.setCaracteristicas(datosProd);
            System.out.println("datos");


            //cuarto quien lo vende
            try{
                WebElement provedorArt= driver.findElement(By.xpath("//span[starts-with(@class, 'ui-pdp-color--BLACK ui-pdp-size--LARGE ui-pdp-family--')]"));
                prod.setVendedor(provedorArt.getText());
                System.out.println("vendedor");
            } catch (Exception e) {
                System.out.println("No se encontro un vendedor");
                prod.setVendedor("");
            }


            //quinto obtener valoraciones.
            try{
                WebElement estrellasArt= driver.findElement(By.xpath("//p[@class='ui-review-capability__rating__average ui-review-capability__rating__average--desktop']"));
                prod.setValoracion(estrellasArt.getText());
                System.out.println("valoracion");
            }catch(Exception e){
                System.out.println("Este articulo no posee valoraciones con estrellas :(");
                prod.setValoracion("");
            }


            //sexto obtener comentarios de compradores(opcional).
            try{
                List<WebElement> commentsArt= driver.findElements(By.xpath("//p[starts-with(@class, 'ui-review-capability-comments')]"));
                List<String> comentarios = new ArrayList<>();

                commentsArt.forEach(comments -> comentarios.add(comments.getText()));
                prod.setComentarios(comentarios);
                System.out.println("comentarios");
            } catch (Exception e) {
                System.out.println("No se encontraron comentarios de compradores");
                prod.setComentarios(null);
            }
            productos.add(prod);
        }
        return productos;
    }
}
