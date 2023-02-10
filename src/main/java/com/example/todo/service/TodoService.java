package com.example.todo.service;

import com.example.todo.entity.TodoEntity;

import java.util.List;
public interface TodoService {
    TodoEntity saveTodo(TodoEntity entity);

    List<TodoEntity> getAllTodo();

    TodoEntity getTodoById(int id);

    TodoEntity updateTodo(TodoEntity entity, int id);

    void deleteTodo(int Id);
}
