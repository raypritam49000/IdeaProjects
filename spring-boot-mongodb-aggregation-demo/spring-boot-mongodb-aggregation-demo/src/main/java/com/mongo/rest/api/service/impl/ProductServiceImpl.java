package com.mongo.rest.api.service.impl;

import com.mongo.rest.api.dto.ProductDTO;
import com.mongo.rest.api.entity.Product;
import com.mongo.rest.api.mapper.ProductEntityMapper;
import com.mongo.rest.api.repository.ProductRepository;
import com.mongo.rest.api.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        return ProductEntityMapper.INSTANCE.toDto(productRepository.save(ProductEntityMapper.INSTANCE.toEntity(productDTO)));
    }

    @Override
    public ProductDTO findProductById(String id) {
        return ProductEntityMapper.INSTANCE.toDto(productRepository.findById(id).get());
    }

    @Override
    public List<ProductDTO> findAllProduct() {
        return ProductEntityMapper.INSTANCE.toDtoList(productRepository.findAll());
    }

    @Override
    public Boolean deleteProductById(String id) throws IllegalAccessException {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            productRepository.delete(productOptional.get());
            return true;
        } else throw new IllegalAccessException("Product Not Found with : " + id);
    }

    @Override
    public ProductDTO updateProduct(String id, ProductDTO productDTO) {
        productDTO.set_id(id);
        return ProductEntityMapper.INSTANCE.toDto(productRepository.save(ProductEntityMapper.INSTANCE.toEntity(productDTO)));
    }

    @Override
    public Optional<ProductDTO> getProductById(String id) {
        return Optional.of(ProductEntityMapper.INSTANCE.toDto(productRepository.getProductById(id).get()));
    }

    @Override
    public List<ProductDTO> getProductsByPages(int price) {
        return ProductEntityMapper.INSTANCE.toDtoList(productRepository.getProductsByPages(price));
    }

    @Override
    public List<ProductDTO> getProductByItem(String item) {
        return ProductEntityMapper.INSTANCE.toDtoList(productRepository.getProductByItem(item));
    }

    @Override
    public List<ProductDTO> getProductsByPriceAndItem(int price, String item) {
        return ProductEntityMapper.INSTANCE.toDtoList(productRepository.getProductByItem(item));
    }

    @Override
    public List<ProductDTO> getProductsByPriceOrItem(int price, String item) {
        return ProductEntityMapper.INSTANCE.toDtoList(productRepository.getProductsByPriceOrItem(price, item));
    }

    @Override
    public Integer getProductCountByItem(String item) {
        return productRepository.getProductCountByItem(item);
    }

    @Override
    public List<ProductDTO> getProductsByItemSortByPrice(String item) {
        return ProductEntityMapper.INSTANCE.toDtoList(productRepository.getProductsByItemSortByPrice(item));
    }

    @Override
    public List<ProductDTO> getProductPriceAndItemByPages(Integer pages) {
        return ProductEntityMapper.INSTANCE.toDtoList(productRepository.getProductPriceAndItemByPages(pages));
    }

    @Override
    public List<ProductDTO> getAllProductsByItem(String item) {
        return ProductEntityMapper.INSTANCE.toDtoList(productRepository.getAllProductsByItem(item));
    }

    @Override
    public List<ProductDTO> getProductsByItemRegEx(String item) {
        return ProductEntityMapper.INSTANCE.toDtoList(productRepository.getProductsByItemRegEx(item));
    }

}
