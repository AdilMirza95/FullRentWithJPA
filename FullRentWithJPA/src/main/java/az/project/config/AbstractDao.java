package az.project.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ADIL
 */
public abstract class AbstractDao {

    public static EntityManagerFactory emf = null;

    public static EntityManager createEM() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("az.Project_FullRentWithJPA_jar_1.0PU");           
        }
        return emf.createEntityManager();
    }
    
    public static void closeEM(EntityManager em) {
        em.close();
    }
    
    public static void closeEMF(EntityManagerFactory emf) {
        emf.close();
    }
}
