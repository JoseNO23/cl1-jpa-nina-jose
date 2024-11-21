package pe.edu.i202216351.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202216351.entity.*;

public class JPARemove {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Country country = em.find(Country.class, "IMG");
        if (country != null) {
            em.remove(country);
            System.out.println("País y sus asociaciones eliminadas correctamente.");
        } else {
            System.out.println("País no encontrado.");
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
