package com.gpli.backend.repository;

import com.gpli.backend.entity.TicketCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TicketCostRepository extends JpaRepository<TicketCost, Long> {
    List<TicketCost> findByTicketId(Integer ticketId);
    boolean existsByTicketId(Integer ticketId);
    Optional<TicketCost> findTopByTicketIdOrderByCreatedAtDesc(Integer ticketId);
}
