package dal;

import model.Todo;

import java.util.List;
import java.util.Optional;

public interface dbrepo {
    List<Todo> gettodo();
    Todo createtodo(Todo todo);
    Todo updatetodo(String id,Todo newTodo);
    void deleteById(String id);
    Optional<Todo>getTodoById(String id);
}
