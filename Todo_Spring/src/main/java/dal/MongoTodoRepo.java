package dal;

import model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MongoTodoRepo implements dbrepo {

    @Autowired
    private mongorepo mongorepo;

    @Override
    public List<Todo> gettodo() {
        return mongorepo.findAll();
    }

    @Override
    public Todo createtodo(Todo todo) {
        return mongorepo.save(todo);
    }

    @Override
    public Todo updatetodo(String id, Todo newTodo) {
        if(!mongorepo.existsById(id)) {
            throw new RuntimeException("Not found");
        }
        newTodo.setId(id);
        return  mongorepo.save(newTodo);

    }

    @Override
    public void deleteById(String id) {
        if(!mongorepo.existsById(id)){
            throw new RuntimeException("Not found");
        }
        mongorepo.deleteById(id);

    }

    @Override
    public Optional<Todo> getTodoById(String id) {
        return null;
    }


}
