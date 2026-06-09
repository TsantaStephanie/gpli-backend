package com.gpli.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "kanban_settings")
@Data
public class KanbanSettings {

    @Id
    @Column(name = "column_id")
    private String columnId;   // "new" | "progress" | "done"

    @Column(nullable = false)
    private String color;      // couleur hex ex: "#3b82f6"

    @Column(name = "label_mg")
    private String labelMg;    // nom en malgache ex: "Vaovao"
}
