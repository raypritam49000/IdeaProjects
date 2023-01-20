package com.data.jdbc.rest.api.dto;

import com.data.jdbc.rest.api.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
  private Long id;
  private String name;
  private String membership;
  private Address address;

  public CustomerDTO(String name, String membership, Address address) {
    this.name = name;
    this.membership = membership;
    this.address = address;
  }
}