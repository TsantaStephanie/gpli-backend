package com.gpli.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import lombok.ToString;

@Entity
@Table(name = "users")
@Data
public class User {

    // Clé primaire auto-générée
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nom complet de l'utilisateur : "Rakoto Jean", "ITU Labs"...
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // Liste des matériels assignés à cet utilisateur
    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<Asset> assets;
}
