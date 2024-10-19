package config;

import dal.MongoTodoRepo;
import dal.Inmemory;
import dal.dbrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Todoconfig {

    @Value("${db.type}")
    private String dbtype;

    @Autowired
    private MongoTodoRepo mongoRep;

    @Autowired
    private Inmemory inmemory;

    public Todoconfig(MongoTodoRepo mongoRep, Inmemory inmemory) {
        this.mongoRep = mongoRep;
        this.inmemory = inmemory;
    }

    @Bean(name = "todorepository")
    public dbrepo Todorep() {
        if ("inmemory".equalsIgnoreCase(dbtype)) {
            return inmemory;
        } else if ("mongo".equalsIgnoreCase(dbtype)) {
            return mongoRep;
        } else {
            throw new IllegalArgumentException("Invalid database type: " + dbtype);
        }
    }


}


