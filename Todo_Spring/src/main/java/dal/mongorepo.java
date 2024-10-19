package dal;

import model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface mongorepo extends MongoRepository <Todo , String> {
}
