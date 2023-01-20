package com.rest.criteriaquery.api.service;

import com.rest.criteriaquery.api.dto.ProductDTO;
import com.rest.criteriaquery.api.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ProductService {
    public ProductDTO createProduct(ProductDTO productDTO);
    public List<ProductDTO> getProducts(int offset, int limit);
    public List<ProductDTO> getProductByName(String name);
    public List<ProductDTO> getProductByNameAndPrice(String name, BigDecimal price);
    public List<ProductDTO> getProductByPriceRange(BigDecimal starPrice ,BigDecimal endPrice);
    public ProductDTO minimumPriceProduct();
    public List<ProductDTO> getProductsByIds(List<String> ids);
    public Map<String, List<Product>> getProductGroupByName();
}
