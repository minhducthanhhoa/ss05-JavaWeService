package com.data.sesson05_javawebservice.controller;

import com.data.sesson05_javawebservice.entity.Product2;
import com.data.sesson05_javawebservice.entity.ProductList2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products2")
public class Product2Controller {

    private List<Product2> productList = List.of(
            new Product2(1L, "Laptop", 1500.0),
            new Product2(2L, "Mouse", 25.5),
            new Product2(3L, "Keyboard", 45.0)
    );


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product2> getAllProductsJson() {
        return productList;
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ProductList2 getAllProductsXml() {
        return new ProductList2(productList);
    }
}
