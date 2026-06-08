package com.gpli.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import lombok.ToString;

@Entity
@Table(name = "item_types")
@Data
public class ItemType {

    // Clé primaire auto-générée
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nom du type : "Computer", "Monitor"...
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // Liste des matériels de ce type
    @ToString.Exclude
    @OneToMany(mappedBy = "itemType")
    private List<Asset> assets;
}
