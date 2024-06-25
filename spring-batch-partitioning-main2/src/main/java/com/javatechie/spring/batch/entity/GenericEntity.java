package com.javatechie.spring.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "CUSTOMERS_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ElementCollection
    @MapKeyColumn(name = "field_name")
    @Column(name = "field_value")
    @CollectionTable(name = "generic_entity_fields", joinColumns = @JoinColumn(name = "entity_id"))
    private Map<String, String> fields = new HashMap<>();
}
