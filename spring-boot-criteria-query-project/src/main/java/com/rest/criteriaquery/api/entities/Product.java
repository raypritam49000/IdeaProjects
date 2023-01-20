package com.rest.criteriaquery.api.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
@Builder
public class Product implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "product_id")
    private String id;
    private String name;
    private BigDecimal price;
    private int quantity;
}
