package com.todo.todo_app.services;

import com.todo.todo_app.models.Task;
import com.todo.todo_app.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll(); //readily available out-of-box
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("Invalid Task Id");
                });
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
