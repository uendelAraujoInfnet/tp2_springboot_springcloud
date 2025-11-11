package com.example.taskapi.service;

import com.example.taskapi.model.Task;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final Map<Long, Task> tasks = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(tasks.get(id));
    }

    public Task create(Task task) {
        long id = counter.getAndIncrement();
        task.setId(id);
        tasks.put(id, task);
        return task;
    }

    public Optional<Task> update(Long id, Task task) {
        if (!tasks.containsKey(id)) return Optional.empty();
        task.setId(id);
        tasks.put(id, task);
        return Optional.of(task);
    }

    public boolean delete(Long id) {
        return tasks.remove(id) != null;
    }
}
