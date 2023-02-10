package com.example.todo.controller;

import com.example.todo.entity.TodoEntity;
import com.example.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/todo")
public class TodoController {
    private TodoService service;

    public TodoController(TodoService service){
        super();
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<TodoEntity> saveTodo(@RequestBody TodoEntity entity){
        return new ResponseEntity<TodoEntity>(service.saveTodo(entity), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<TodoEntity> getAllTodo(){
        return service.getAllTodo();
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoEntity> getTodoById(@PathVariable("id") int id){
        return new ResponseEntity<TodoEntity>(service.getTodoById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoEntity> updateTodo(@PathVariable("id") int id, @RequestBody TodoEntity entity){
        return new ResponseEntity<TodoEntity>(service.updateTodo(entity,id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") int id){
        service.deleteTodo(id);
        return new ResponseEntity<String>("Silindi.",HttpStatus.OK);
    }
}
