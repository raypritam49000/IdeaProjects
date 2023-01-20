package com.rest.criteriaquery.api.controllers;

import com.rest.criteriaquery.api.dto.ProductDTO;
import com.rest.criteriaquery.api.entities.Product;
import com.rest.criteriaquery.api.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{offset}/{limit}")
    public List<ProductDTO> getEmployees(@PathVariable int offset, @PathVariable int limit) {
        return productService.getProducts(offset,limit);
    }

    @GetMapping("/{name}")
    public List<ProductDTO> getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @GetMapping("/fetch/{name}/{price}")
    public List<ProductDTO> getProductByNameAndPrice(@PathVariable String name, @PathVariable BigDecimal price) {
        return productService.getProductByNameAndPrice(name,price);
    }


    @GetMapping("/range/{startPrice}/{endPrice}")
    public List<ProductDTO> getProductByPriceRange(@PathVariable BigDecimal startPrice,@PathVariable BigDecimal endPrice) {
        return productService.getProductByPriceRange(startPrice,endPrice);
    }

    @GetMapping("/min")
    public ProductDTO minimumPriceProduct(){
        return productService.minimumPriceProduct();
    }

    @PostMapping("/ids")
    public  List<ProductDTO> getProductsByIds(@RequestBody List<String> ids){
        return productService.getProductsByIds(ids);
    }

    @GetMapping("/groupByName")
    public Map<String, List<Product>> getProductGroupByName(){
        return productService.getProductGroupByName();
    }
}
