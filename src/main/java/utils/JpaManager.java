package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;

public class JpaManager {

    private static final String PERSISTENCE_UNIT_NAME = "persistence";
    private static EntityManager manager;
    private static EntityManagerFactory managerFactory;

    public EntityManager getManager(){

        HashMap<String,String> props = new HashMap<>();
        props.put("jakarta.persistence.jdbc.password", System.getenv("MYSQL_PASSWORD"));
        //Create new Entity Manager
        managerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, props);
        manager = managerFactory.createEntityManager();
        return manager;
    }
}
