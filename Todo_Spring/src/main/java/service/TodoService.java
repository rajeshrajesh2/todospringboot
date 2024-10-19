package service;

import dal.dbrepo;
import model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final dbrepo dbrepo;

    @Autowired
    public TodoService(@Qualifier("jhjfbefb") dbrepo dbrepo){
        this.dbrepo = dbrepo;
    }
    public List<Todo> getAllTodos(){
        return dbrepo.gettodo();
    }
    public Todo createtodo(Todo todo){
        return dbrepo.createtodo(todo);
    }
    public Todo updatetodo(String id,Todo newTodo){
        return dbrepo.updatetodo(id, newTodo);
    }
    public void deleteById(String id){
         dbrepo.deleteById(id);
    }

}
