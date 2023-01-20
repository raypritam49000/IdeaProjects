package com.data.jdbc.rest.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("CUSTOMER")
public class Customer {
  @Id
  private Long id;
  private String name;
  private String membership;
  private Address address;

  public Customer(String name, String membership, Address address) {
    this.name = name;
    this.membership = membership;
    this.address = address;
  }
}