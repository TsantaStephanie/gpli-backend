package com.gpli.backend.controller;

import com.gpli.backend.entity.TicketCost;
import com.gpli.backend.service.TicketCostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket-costs")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class TicketCostController {

    private final TicketCostService service;

    @GetMapping
    public ResponseEntity<List<TicketCost>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<TicketCost> create(@RequestBody TicketCost cost) {
        return ResponseEntity.ok(service.save(cost));
    }

    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<TicketCost>> getByTicket(@PathVariable Integer ticketId) {
        return ResponseEntity.ok(service.getByTicketId(ticketId));
    }

    @GetMapping("/ticket/{ticketId}/latest")
    public ResponseEntity<TicketCost> getLatest(@PathVariable Integer ticketId) {
        return service.getLatestByTicketId(ticketId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketCost> update(@PathVariable Long id, @RequestBody TicketCost update) {
        return service.updateById(id, update)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/ticket/{ticketId}/latest")
    public ResponseEntity<Void> deleteLatest(@PathVariable Integer ticketId) {
        service.deleteLatestByTicketId(ticketId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        service.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
