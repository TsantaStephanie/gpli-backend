package com.gpli.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import java.util.List;

@Entity
@Table(name = "assets")
@Data
@EqualsAndHashCode(of = "id")
public class Asset {

    // Clé primaire auto-générée par SQLite
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nom du matériel ex: PC-ADM-001 (unique car identifiant métier)
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // Statut : "En production", "Maintenance", "En panne", "En stock"
    @Column(name = "status")
    private String status;

    // Relation Many-to-One avec Manufacturer
    // Plusieurs assets peuvent avoir le même fabricant
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    // Modèle : OptiPlex 7010, ProDesk 400 G9...
    @Column(name = "model")
    private String model;

    // Numéro d'inventaire unique : ITU-2026-0001
    @Column(name = "inventory_number", unique = true)
    private String inventoryNumber;

    // Relation Many-to-One avec Location
    // Plusieurs assets peuvent être dans le même lieu
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    // Relation Many-to-One avec ItemType
    // Plusieurs assets peuvent être du même type
    @ManyToOne
    @JoinColumn(name = "item_type_id")
    private ItemType itemType;

    // Relation Many-to-One avec User
    // Plusieurs assets peuvent être assignés au même utilisateur
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Relation inverse avec Ticket
    @ToString.Exclude
    @ManyToMany(mappedBy = "assets")
    private List<Ticket> tickets;
}
