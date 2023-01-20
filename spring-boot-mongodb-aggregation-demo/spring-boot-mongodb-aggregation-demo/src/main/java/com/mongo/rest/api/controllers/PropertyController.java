package com.mongo.rest.api.controllers;

import com.mongo.rest.api.dto.PropertyDTO;
import com.mongo.rest.api.dto.PropertySearchParameters;
import com.mongo.rest.api.entity.Property;
import com.mongo.rest.api.service.PropertyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addProperties")
    public ResponseEntity<List<PropertyDTO>> addProperties() {

        List<PropertyDTO> propertyDTOList = List.of(
                new PropertyDTO(100000, 45, "Apartment", "For Sale"),
                new PropertyDTO(65000, 48, "Apartment", "For Sale"),
                new PropertyDTO(280000, 75, "Apartment", "For Sale"),
                new PropertyDTO(452000, 110, "House", "For Sale"),
                new PropertyDTO(400000, 125, "House", "For Rent"),
                new PropertyDTO(125000, 100, "Apartment", "For Sale"),
                new PropertyDTO(95000, 70, "House", "For Rent"),
                new PropertyDTO(35000, 25, "Apartment", "For Sale")
        );

        return ResponseEntity.ok().body(propertyService.createAllProperties(propertyDTOList));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addProperty")
    public ResponseEntity<PropertyDTO> addProperty(@RequestBody PropertyDTO propertyDTO) {
        return ResponseEntity.ok().body(propertyService.createProperty(propertyDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findPropertiesForSale")
    public ResponseEntity<List<PropertyDTO>> findPropertiesForSale(){
        return ResponseEntity.ok().body(propertyService.findPropertiesForSale());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findExpensivePropertiesForSale")
    public ResponseEntity<List<PropertyDTO>> findExpensivePropertiesForSale(){
        return ResponseEntity.ok().body(propertyService.findExpensivePropertiesForSale());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findPropertiesByTransactionTypeAndPriceGTPositional/{transactionType}/{price}")
    public ResponseEntity<List<PropertyDTO>> findPropertiesByTransactionTypeAndPriceGTPositional(@PathVariable("transactionType") String transactionType,@PathVariable("price") int price) {
        return ResponseEntity.ok().body(propertyService.findPropertiesByTransactionTypeAndPriceGTPositional(transactionType, price));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findPropertiesByTransactionTypeAndPriceGTNamed/{transactionType}/{price}")
    public ResponseEntity<List<PropertyDTO>> findPropertiesByTransactionTypeAndPriceGTNamed(@PathVariable("transactionType") String transactionType,@PathVariable("price") int price){
        return ResponseEntity.ok().body(propertyService.findPropertiesByTransactionTypeAndPriceGTNamed(transactionType,price));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findPropertiesByTransactionTypeAndPriceGT/{transactionType}/{price}/{sampleSize}")
    public ResponseEntity<List<PropertyDTO>> findPropertiesByTransactionTypeAndPriceGT(@PathVariable("transactionType") String transactionType,@PathVariable("price")  int price, @PathVariable("sampleSize") int sampleSize){
        return ResponseEntity.ok().body(propertyService.findPropertiesByTransactionTypeAndPriceGT(transactionType,price,sampleSize));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAllProperty")
    public ResponseEntity<List<PropertyDTO>> findAllProperty(){
        return ResponseEntity.ok().body(propertyService.findAllProperty());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findByPropertyTypeAndPrice/{propertyType}/{price}")
    public ResponseEntity<List<PropertyDTO>> findByPropertyTypeAndPrice(@PathVariable("propertyType") String propertyType,@PathVariable("price")  int price){
        return ResponseEntity.ok().body(propertyService.findByPropertyTypeAndPrice(propertyType,price));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findPropertyByPropertyTypeAndPrice/{propertyType}/{price}")
    public ResponseEntity<List<PropertyDTO>> findPropertyByPropertyTypeAndPrice(@PathVariable("propertyType") String propertyType, @PathVariable("price") int price){
        return ResponseEntity.ok().body(propertyService.findPropertyByPropertyTypeAndPrice(propertyType,price));
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/searchProperty")
    public ResponseEntity<List<PropertyDTO>> searchProperty(@RequestParam("propertyType") String propertyType,@RequestParam("pageNumber") int pageNumber,@RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok().body(propertyService.searchProperty(propertyType,pageable));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/searchProperty/pagination")
    public ResponseEntity<List<PropertyDTO>> findPropertiesByTransactionTypeAndPriceGTPageable(PropertySearchParameters searchParameters){
        Pageable pageable = PageRequest.of(searchParameters.getPageNumber(), searchParameters.getPageSize());
        return ResponseEntity.ok().body(propertyService.findPropertiesByTransactionTypeAndPriceGTPageable(searchParameters.getTransactionType(),searchParameters.getPrice(),searchParameters.getSampleSize(),pageable));
    }
}
