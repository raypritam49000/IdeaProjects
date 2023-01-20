package com.mongo.rest.api.service;

import com.mongo.rest.api.dto.ProductDTO;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {
    public ProductDTO createProduct(ProductDTO productDTO);
    public ProductDTO findProductById(String id);
    public List<ProductDTO> findAllProduct();
    public Boolean deleteProductById(String id) throws IllegalAccessException;
    public ProductDTO updateProduct(String id,ProductDTO productDTO);

    Optional<ProductDTO> getProductById(String id);
    List<ProductDTO> getProductsByPages(int price);
    List<ProductDTO> getProductByItem(String item);
    List<ProductDTO> getProductsByPriceAndItem(int price, String item);
    List<ProductDTO> getProductsByPriceOrItem(int price, String item);
    Integer getProductCountByItem(String item);
    List<ProductDTO> getProductsByItemSortByPrice(String item);
    List<ProductDTO> getProductPriceAndItemByPages(Integer pages);
    List<ProductDTO> getAllProductsByItem(String item);
    List<ProductDTO> getProductsByItemRegEx(String item);

}
