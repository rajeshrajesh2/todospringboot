package dal;

import model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class Inmemory implements dbrepo {

    private final HashMap<String, Todo> todoapp = new HashMap<>();

    @Override
    public List<Todo> gettodo() {
        return new ArrayList<>(todoapp.values());
    }

    @Override
    public Todo createtodo(Todo todo) {
        if(todo.getId() == null || todo.getId().isEmpty()){
            todo.setId(generateNewId());
        }
        todoapp.put(todo.getId(),todo);
        return todo;
    }

    @Override
    public Todo updatetodo(String id, Todo newTodo) {
        if(todoapp.containsKey(id)){
            newTodo.setId(id);
            todoapp.put(id,newTodo);
            return newTodo;
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        todoapp.remove(id);

    }

    @Override
    public Optional<Todo> getTodoById(String id) {
        return null;
    }
    private String generateNewId(){
        return String.valueOf(todoapp.size()+4343232);
    }
}
