package com.gpli.backend.service;

import com.gpli.backend.entity.KanbanSettings;
import com.gpli.backend.repository.KanbanSettingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KanbanSettingsService {

    private final KanbanSettingsRepository repository;

    @Transactional
    public List<KanbanSettings> getAll() {
        List<KanbanSettings> settings = repository.findAll();
        if (settings.isEmpty()) {
            return repository.saveAll(defaults());
        }
        return settings;
    }

    @Transactional
    public List<KanbanSettings> saveAll(List<KanbanSettings> settings) {
        return repository.saveAll(settings);
    }

    private List<KanbanSettings> defaults() {
        KanbanSettings s1 = new KanbanSettings();
        s1.setColumnId("new");
        s1.setColor("#3b82f6");
        s1.setLabelMg("Vaovao");

        KanbanSettings s2 = new KanbanSettings();
        s2.setColumnId("progress");
        s2.setColor("#f59e0b");
        s2.setLabelMg("Efa manao");

        KanbanSettings s3 = new KanbanSettings();
        s3.setColumnId("done");
        s3.setColor("#22c55e");
        s3.setLabelMg("Vita");

        return List.of(s1, s2, s3);
    }
}
