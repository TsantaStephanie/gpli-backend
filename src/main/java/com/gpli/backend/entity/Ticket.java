package com.gpli.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "tickets")
@Data
@EqualsAndHashCode(of = "id")
public class Ticket {

    // Clé primaire auto-générée par SQLite
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Numéro de référence du ticket : 1, 2, 3... (unique)
    @Column(name = "ref_ticket", unique = true)
    private Integer refTicket;

    // Date de création du ticket : 03/06/2026
    @Column(name = "date")
    private LocalDate date;

    // Heure de création : 13:45
    @Column(name = "heure")
    private LocalTime heure;

    // Type : "Incident", "Demande"...
    @Column(name = "type")
    private String type;

    // Titre du ticket
    @Column(name = "titre")
    private String titre;

    // Description détaillée
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // Statut : "New", "En cours", "Résolu", "Fermé"
    @Column(name = "status")
    private String status;

    // Priorité : "Low", "Medium", "High", "Very High"
    @Column(name = "priority")
    private String priority;

    // Relation Many-to-Many avec Asset
    // Un ticket peut concerner plusieurs matériels
    // Un matériel peut être dans plusieurs tickets
    // JoinTable crée une table intermédiaire "ticket_assets" dans SQLite
    @ToString.Exclude
    @ManyToMany
    @JoinTable(
        name = "ticket_assets",
        joinColumns = @JoinColumn(name = "ticket_id"),
        inverseJoinColumns = @JoinColumn(name = "asset_id")
    )
    private List<Asset> assets;

    // Relation One-to-Many avec TicketCost
    // Un ticket peut avoir plusieurs lignes de coûts (Feuille 3)
    // cascade = ALL : si on supprime un ticket, ses coûts sont supprimés aussi
    @ToString.Exclude
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<TicketCost> costs;
}
