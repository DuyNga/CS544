package main;

import domain.Flight;
import domain.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PassengerApp {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {

        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Passenger passenger = new Passenger("John Miller");
        Flight flight = new Flight("ABC123");
        Flight flight1 = new Flight("ABC001");
        passenger.addFlight(flight);
        passenger.addFlight(flight1);
        em.persist(passenger);
        em.getTransaction().commit();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Passenger> passengers = em.createQuery("from Passenger", Passenger.class).getResultList();
        System.out.println("RESULTS");
        for (Passenger passenger1 : passengers) {
            System.out.println(passenger1);
        }
        em.getTransaction().commit();
    }
}
