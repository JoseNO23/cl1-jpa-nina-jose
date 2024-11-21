package pe.edu.i202216351.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202216351.entity.*;

public class JPAPersist {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Crear un país
        Country country = new Country();
        country.setCode("IMG");
        country.setName("ImgCountry");
        country.setContinent(Country.Continent.Asia);
        country.setRegion("RegionCountry");
        country.setSurfaceArea(5000000);
        country.setIndepYear(2024);
        country.setPopulation(5000000);
        country.setLifeExpectancy(75.0);
        country.setGNP(1000.0);
        country.setGNPOld(900.0);
        country.setLocalName("Img Local Name");
        country.setGovernmentForm("Republic");
        country.setHeadOfState("John Doe");
        country.setCapital(12345);
        country.setCode2("IG");

        // 3 ciudades
        City city1 = new City();
        city1.setName("city1");
        city1.setCountryCode("IMG");
        city1.setDistrict("district1");
        city1.setPopulation(1500000);

        City city2 = new City();
        city2.setName("city2");
        city2.setCountryCode("IMG");
        city2.setDistrict("district2");
        city2.setPopulation(2000000);

        City city3 = new City();
        city3.setName("city3");
        city3.setCountryCode("IMG");
        city3.setDistrict("district3");
        city3.setPopulation(1500000);

        // 2 lenguajes
        Countrylanguage language1 = new Countrylanguage();
        language1.setCountryCode("IMG");
        language1.setLanguage("language1");
        language1.setIsOfficial(Countrylanguage.isOfficial.T);
        language1.setPercentage(60.0);

        Countrylanguage language2 = new Countrylanguage();
        language2.setCountryCode("IMG");
        language2.setLanguage("language2");
        language2.setIsOfficial(Countrylanguage.isOfficial.F);
        language2.setPercentage(40.0);

        // Persistir
        em.persist(country);
        em.persist(city1);
        em.persist(city2);
        em.persist(city3);
        em.merge(language1);
        em.merge(language2);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("País, ciudades y lenguajes registrados correctamente.");
    }
}

