package controller;

import model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.TodoService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class Todocontroller {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();

    }
    @PostMapping
    public Optional<Todo> createTodo(@RequestBody Todo todo){
        Todo createTodo = todoService.createtodo(todo);
        return Optional.ofNullable(createTodo);
    }
    @PutMapping("/{id}")
    public Optional<Todo> updateTodo(@PathVariable String id,@RequestBody Todo newTodo){
        return Optional.ofNullable(todoService.updatetodo(id,newTodo));
    }
    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable String id){
        todoService.deleteById(id);
    }

}
