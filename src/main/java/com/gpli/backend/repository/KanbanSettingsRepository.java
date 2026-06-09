package com.gpli.backend.repository;

import com.gpli.backend.entity.KanbanSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KanbanSettingsRepository extends JpaRepository<KanbanSettings, String> {
}
