package com.gpli.backend.service;

import com.gpli.backend.entity.TicketCost;
import com.gpli.backend.repository.TicketCostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketCostService {

    private final TicketCostRepository repository;

    public List<TicketCost> getAll() {
        return repository.findAll();
    }

    public TicketCost save(TicketCost cost) {
        return repository.save(cost);
    }

    public List<TicketCost> getByTicketId(Integer ticketId) {
        return repository.findByTicketId(ticketId);
    }

    public Optional<TicketCost> getLatestByTicketId(Integer ticketId) {
        return repository.findTopByTicketIdOrderByCreatedAtDesc(ticketId);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public java.util.Optional<TicketCost> updateById(Long id, TicketCost update) {
        return repository.findById(id).map(cost -> {
            cost.setFixedCost(update.getFixedCost());
            cost.setReopenPct(update.getReopenPct());
            cost.setReopenMode(update.getReopenMode());
            return repository.save(cost);
        });
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean deleteLatestByTicketId(Integer ticketID) {
        return repository.findTopByTicketIdOrderByCreatedAtDesc(ticketID)
        .map(cost -> {repository.delete(cost);
            return true;
        })
        .orElse(false);
    }
}
