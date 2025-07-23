package com.todo.todo_app.repositories;

import com.todo.todo_app.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {         //helps to create CRUD operations

}
