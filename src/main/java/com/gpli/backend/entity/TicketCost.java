package com.gpli.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ticket_costs")
@Data
public class TicketCost {

    // Clé primaire auto-générée par SQLite
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation Many-to-One avec Ticket
    // Plusieurs lignes de coûts peuvent appartenir au même ticket
    // @JoinColumn définit la colonne "ticket_id" comme clé étrangère dans la table
    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    // Durée en secondes : 0, 600...
    @Column(name = "duration_second")
    private Integer durationSecond;

    // Coût du temps passé : 0, 8.7...
    @Column(name = "time_cost")
    private Double timeCost;

    // Coût fixe : 109, 50...
    @Column(name = "fixed_cost")
    private Double fixedCost;
}
