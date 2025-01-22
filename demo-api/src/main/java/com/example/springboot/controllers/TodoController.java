package com.example.springboot.controllers;

import com.example.springboot.model.Todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todos") 
public class TodoController {

    // Array for the todos
    private final List<Todo> todos = new ArrayList<>();

    // Create Todo
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        if(newTodo.getTitle() == null){
            return ResponseEntity.badRequest().build();
        }

        newTodo.setId(UUID.randomUUID().toString());
        todos.add(newTodo);

        return ResponseEntity.ok(newTodo);
    }

    // Retrieve all Todos
    @GetMapping
    public List<Todo> getAllTodos() {
        return todos;
    }

    // Update Todo Title
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String id, @RequestBody Todo updatedTodo) {

    if(updatedTodo.getTitle() == null){
        return ResponseEntity.badRequest().build();
    }
    // Find Todo by id
    Todo existingTodo = todos.stream()
        .filter(todo -> todo.getId().equals(id))
        .findFirst()
        .orElse(null);

    // Check if Todo exist
    if (existingTodo == null) {
        return ResponseEntity.notFound().build();
    }
    

    // Update the Todo Title
    existingTodo.setTitle(updatedTodo.getTitle());
    // Update the Todo Completed
    existingTodo.setCompleted(updatedTodo.isCompleted());

    // Return the updated Todo and a 200 statusmessage (ok)
    return ResponseEntity.ok(existingTodo);
}

// Add Delete Todo 

}
