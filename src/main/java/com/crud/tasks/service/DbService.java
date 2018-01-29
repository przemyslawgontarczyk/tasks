package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Component
public class DbService {
    @Autowired
    private TaskRepository repository;

    public List<Task> getAlTasks() {
        return repository.findAll();
    }
    public Optional<Task> getTaskById(final Long id) {
        return repository.findById(id);
    }
}
