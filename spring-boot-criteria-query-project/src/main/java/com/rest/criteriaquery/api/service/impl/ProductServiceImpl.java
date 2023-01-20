package com.rest.criteriaquery.api.service.impl;

import com.rest.criteriaquery.api.dto.ProductDTO;
import com.rest.criteriaquery.api.entities.Product;
import com.rest.criteriaquery.api.entities.Product$;
import com.rest.criteriaquery.api.repository.ProductRepository;
import com.rest.criteriaquery.api.service.ProductService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final JPAStreamer jpaStreamer;

    public ProductServiceImpl(ProductRepository productRepository, JPAStreamer jpaStreamer) {
        this.productRepository = productRepository;
        this.jpaStreamer = jpaStreamer;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {

        Product product = Product.builder().id(productDTO.getId()).name(productDTO.getName())
                .price(productDTO.getPrice()).quantity(productDTO.getQuantity()).build();

        Product createProduct = productRepository.save(product);

        ProductDTO createProductDTO = ProductDTO.builder().id(createProduct.getId()).name(createProduct.getName())
                .price(createProduct.getPrice()).quantity(createProduct.getQuantity()).build();
        return createProductDTO;
    }

    @Override
    public List<ProductDTO> getProducts(int offset, int limit) {
        List<Product> products = jpaStreamer
                .stream(Product.class)
                .sorted(Product$.name)
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());

        List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();

        products.forEach(product -> {
            ProductDTO productDTO = ProductDTO.builder().id(product.getId()).name(product.getName())
                    .price(product.getPrice()).quantity(product.getQuantity()).build();

            productDTOS.add(productDTO);
        });

        return productDTOS;
    }

    @Override
    public List<ProductDTO> getProductByName(String name) {
        List<Product> products = jpaStreamer.stream(Product.class)
                .filter(Product$.name.equal(name))
                .collect(Collectors.toList());

        List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();

        products.forEach(product -> {
            ProductDTO productDTO = ProductDTO.builder().id(product.getId()).name(product.getName())
                    .price(product.getPrice()).quantity(product.getQuantity()).build();

            productDTOS.add(productDTO);
        });

        return productDTOS;
    }

    @Override
    public List<ProductDTO> getProductByNameAndPrice(String name, BigDecimal price) {
        List<Product> products = jpaStreamer.stream(Product.class)
                .filter(Product$.name.equal(name)
                        .and(Product$.price.greaterOrEqual(price)))
                .collect(Collectors.toList());

        List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();

        products.forEach(product -> {
            ProductDTO productDTO = ProductDTO.builder().id(product.getId()).name(product.getName())
                    .price(product.getPrice()).quantity(product.getQuantity()).build();

            productDTOS.add(productDTO);
        });

        return productDTOS;
    }


    @Override
    public List<ProductDTO> getProductByPriceRange(BigDecimal starPrice ,BigDecimal endPrice){
        List<Product> products =  jpaStreamer.stream(Product.class)
                .filter(Product$.price.between(starPrice,endPrice))
                .collect(Collectors.toList());

        List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();

        products.forEach(product -> {
            ProductDTO productDTO = ProductDTO.builder().id(product.getId()).name(product.getName())
                    .price(product.getPrice()).quantity(product.getQuantity()).build();

            productDTOS.add(productDTO);
        });

        return productDTOS;
    }


    @Override
    public ProductDTO minimumPriceProduct(){

        Product product = jpaStreamer.stream(Product.class)
                .min(Comparator.comparing(Product::getPrice)).get();

        ProductDTO productDTO = ProductDTO.builder().id(product.getId()).name(product.getName())
                .price(product.getPrice()).quantity(product.getQuantity()).build();

        return productDTO;
    }

    @Override
    public List<ProductDTO> getProductsByIds(List<String> ids){
        List<Product> products = jpaStreamer.stream(Product.class)
                .filter(Product$.id.in(ids))
                .collect(Collectors.toList());

        List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();

        products.forEach(product -> {
            ProductDTO productDTO = ProductDTO.builder().id(product.getId()).name(product.getName())
                    .price(product.getPrice()).quantity(product.getQuantity()).build();

            productDTOS.add(productDTO);
        });

        return productDTOS;
    }

    @Override
    public Map<String, List<Product>> getProductGroupByName(){
        Map<String, List<Product>> listMap = jpaStreamer.stream(Product.class)
                .collect(Collectors.groupingBy(Product::getName));
        return listMap;
    }
}
