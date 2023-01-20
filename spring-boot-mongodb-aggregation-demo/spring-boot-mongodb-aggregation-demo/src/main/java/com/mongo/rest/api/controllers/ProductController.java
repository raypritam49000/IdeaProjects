package com.mongo.rest.api.controllers;

import com.mongo.rest.api.dto.ProductDTO;
import com.mongo.rest.api.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDTO createProduct(ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @GetMapping("/{id}")
    public ProductDTO findProductById(String id) {
        return productService.findProductById(id);
    }

    @GetMapping("/findAllProduct")
    public List<ProductDTO> findAllProduct() {
        return productService.findAllProduct();
    }

    @DeleteMapping
    public Boolean deleteProductById(String id) throws IllegalAccessException {
        return productService.deleteProductById(id);
    }


    @PutMapping
    public ProductDTO updateProduct(String id, ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    @GetMapping
    public ProductDTO getProductById(String id) {
        return productService.getProductById(id).get();
    }

    @GetMapping("/getProductsByPages/{price}")
    public List<ProductDTO> getProductsByPages(@PathVariable("price") int price) {
        return productService.getProductsByPages(price);
    }

    @GetMapping("/getProductByItem/{item}")
    public List<ProductDTO> getProductByItem(@PathVariable("item") String item) {
        return productService.getProductByItem(item);
    }

    @GetMapping("/getProductsByPriceAndItem/{price}/{item}")
    public List<ProductDTO> getProductsByPriceAndItem(@PathVariable("price") int price, @PathVariable("item") String item) {
        return null;
    }

    @GetMapping("/getProductsByPriceOrItem/{price}/{item}")
    public List<ProductDTO> getProductsByPriceOrItem(@PathVariable("price") int price, @PathVariable("item") String item) {
        return productService.getProductsByPriceOrItem(price,item);
    }

    @GetMapping("/getProductCountByItem/{item}")
    public Integer getProductCountByItem(@PathVariable("item") String item) {
        return productService.getProductCountByItem(item);
    }

    @GetMapping("/getProductsByItemSortByPrice/{item}")
    public List<ProductDTO> getProductsByItemSortByPrice(@PathVariable("item") String item) {
        return productService.getProductsByItemSortByPrice(item);
    }

    @GetMapping("/getProductPriceAndItemByPages/{pages}")
    public List<ProductDTO> getProductPriceAndItemByPages(@PathVariable("pages") Integer pages) {
        return productService.getProductPriceAndItemByPages(pages);
    }

    @GetMapping("/getAllProductsByItem/{item}")
    public List<ProductDTO> getAllProductsByItem(@PathVariable("item") String item) {
        return productService.getAllProductsByItem(item);
    }

    @GetMapping("/getProductsByItemRegEx/{item}")
    public List<ProductDTO> getProductsByItemRegEx(@PathVariable("item") String item) {
        return productService.getProductsByItemRegEx(item);
    }
}
