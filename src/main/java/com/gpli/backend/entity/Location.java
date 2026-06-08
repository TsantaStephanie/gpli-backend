package com.gpli.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import lombok.ToString;

@Entity
@Table(name = "locations")
@Data
public class Location {

    // Clé primaire auto-générée
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nom du lieu : "Administration", "Comptabilité", "Laboratoire IA"...
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // Liste des matériels dans ce lieu
    @ToString.Exclude
    @OneToMany(mappedBy = "location")
    private List<Asset> assets;
}
