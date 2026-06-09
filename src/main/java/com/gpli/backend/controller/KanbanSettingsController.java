package com.gpli.backend.controller;

import com.gpli.backend.entity.KanbanSettings;
import com.gpli.backend.service.KanbanSettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kanban-settings")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class KanbanSettingsController {

    private final KanbanSettingsService service;

    @GetMapping
    public ResponseEntity<List<KanbanSettings>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping
    public ResponseEntity<List<KanbanSettings>> saveAll(@RequestBody List<KanbanSettings> settings) {
        return ResponseEntity.ok(service.saveAll(settings));
    }
}
