package com.gpli.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket_cost")
@Data
public class TicketCost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_id", nullable = false)
    private Integer ticketId;

    @Column(name = "ticket_title")
    private String ticketTitle;

    @Column(name = "fixed_cost", nullable = false)
    private Double fixedCost;

    /** Nombre d'actifs liés au ticket (pour diviser le coût) */
    @Column(name = "item_count")
    private Integer itemCount;

    /** Types des actifs sérialisés en JSON : ["Computer","Monitor","Computer"] */
    @Column(name = "item_types", length = 2000)
    private String itemTypes;

    /**
     * Origine du coût : "glpi" (importé depuis GLPI/Feuille 3)
     *                   "kanban" (saisi via le dialog Kanban)
     */
    @Column(name = "source", length = 20)
    private String source;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
    }
}
