package com.example.Plant.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PLANTS")
public class Plant {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "WATERING_FREQUENCY")
    private Integer wateringFrequency;

    @Column(name = "HAS_FRUIT")
    private Boolean hasFruit;
}
