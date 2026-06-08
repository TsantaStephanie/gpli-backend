package com.gpli.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.util.List;

@Entity
@Table(name = "manufacturers")
@Data
public class Manufacturer {

    // Clé primaire auto-générée
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nom du fabricant : "Dell", "HP", "Lenovo"...
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // Liste des matériels de ce fabricant
    @ToString.Exclude
    @OneToMany(mappedBy = "manufacturer")
    private List<Asset> assets;
}
