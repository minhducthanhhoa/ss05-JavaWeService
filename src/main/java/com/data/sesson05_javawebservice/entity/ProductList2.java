package com.data.sesson05_javawebservice.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "products")
public class ProductList2 {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "product")
    private List<Product2> products;

    public ProductList2() {
    }

    public ProductList2(List<Product2> products) {
        this.products = products;
    }

    public List<Product2> getProducts() {
        return products;
    }

    public void setProducts(List<Product2> products) {
        this.products = products;
    }
}
