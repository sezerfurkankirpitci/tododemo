package com.example.todo.service;

import com.example.todo.entity.TodoEntity;
import com.example.todo.repository.TodoRepositoty;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoServiceImpl implements TodoService{
    private TodoEntity entity;
    private TodoRepositoty todoRepositoty;
    public TodoServiceImpl(TodoRepositoty todoRepositoty){
        super();
        this.todoRepositoty = todoRepositoty;
    }
    @Override
    public TodoEntity saveTodo(TodoEntity entity) {
        return todoRepositoty.save(entity);
    }

    @Override
    public List<TodoEntity> getAllTodo() {
        return todoRepositoty.findAll();
    }

    @Override
    public TodoEntity getTodoById(int id) {
        return todoRepositoty.findById(id).orElse(null);
    }

    @Override
    public TodoEntity updateTodo(TodoEntity entity, int id) {
        TodoEntity updatedEntity = new TodoEntity();
        updatedEntity.setId(id);
        updatedEntity.setName(entity.getName());
        todoRepositoty.save(updatedEntity);
        return updatedEntity;
    }

    @Override
    public void deleteTodo(int id) {
        todoRepositoty.deleteById(id);
    }
}
