package com.example.todo.repository;

import com.example.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepositoty extends JpaRepository<TodoEntity, Integer> {

}
