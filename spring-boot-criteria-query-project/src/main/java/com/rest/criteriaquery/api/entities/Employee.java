package com.rest.criteriaquery.api.entities;

import com.rest.criteriaquery.api.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries(value = {
        @NamedQuery(name = "Employee.findEmployeeById", query = "SELECT e from Employee e WHERE e.id=?1"),
        @NamedQuery(name = "Employee.findEmployeeByName", query = "SELECT e from Employee e WHERE e.name=?1"),
})
public class Employee {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "employee_id")
    private String id;
    private String name;
    private String city;
    private String email;
    private String department;
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
