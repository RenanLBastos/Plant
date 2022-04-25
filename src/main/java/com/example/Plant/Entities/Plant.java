package com.example.Plant.Entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PLANTS")
public class Plant {
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue
    private Integer id;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @Column(name = "NAME")
    private String name;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @Column(name = "QUANTITY")
    private Integer quantity;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @Column(name = "WATERING_FREQUENCY")
    private Integer wateringFrequency;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @Column(name = "HAS_FRUIT")
    private Boolean hasFruit;
}
