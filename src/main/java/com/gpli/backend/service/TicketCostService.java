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

    public boolean deleteLatestByTicketId(Integer ticketId) {
        return repository.findTopByTicketIdOrderByCreatedAtDesc(ticketId)
            .map(cost -> { repository.delete(cost); return true; })
            .orElse(false);
    }
}
