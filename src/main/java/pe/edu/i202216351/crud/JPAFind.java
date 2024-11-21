package pe.edu.i202216351.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202216351.entity.*;

import java.util.List;

public class JPAFind {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country peru = em.find(Country.class, "PER");
        if (peru != null) {
            System.out.println("Ciudades en Perú con población mayor a 700,000:");
            // Consulta las ciudades con población mayor a 700,000
            List<City> cities = em.createQuery(
                            "SELECT c FROM City c WHERE c.CountryCode = 'PER' AND c.Population > 700000", City.class)
                    .getResultList();

            // Usar lambda para imprimir los resultados
            cities.forEach(city -> System.out.println(city.getName()));
        } else {
            System.out.println("El país no fue encontrado.");
        }

        em.close();
        emf.close();
    }
}