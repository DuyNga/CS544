package edu.mum.cs544;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.mum.cs544.model.Airline;
import edu.mum.cs544.model.Flight;

import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

import javax.persistence.*;

public class App {
    private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
            Locale.US);
//private static DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.US);

    private static DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
            Locale.US);

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // a) TODO: Flights leaving USA capacity > 500
        System.out.println("Question A:");
        TypedQuery<Flight> flightTypedQuery =
                em.createQuery(
                        "from Flight f where f.airplane.capacity" +
                                " > 500 And f.origin.country = :country  ", Flight.class);
        flightTypedQuery.setParameter("country", "USA");
        List<Flight> flights = flightTypedQuery.getResultList();

        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // b) TODO: All airlines that use A380 airplanes
        System.out.println("Question B:");
        TypedQuery<Airline> airlineTypedQuery = em.createQuery("select distinct f.airline from Flight f  " +
                " join f.airline where f.airplane.model = :model", Airline.class);
        airlineTypedQuery.setParameter("model", "A380");
        List<Airline> airlines = airlineTypedQuery.getResultList();
        System.out.println("Airlines that use A380s:");
        for (Airline airline : airlines) {
            System.out.println(airline.getName());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // c) TODO: Flights using 747 planes that don't belong to Star Alliance
        System.out.println("Question C:");
        flightTypedQuery = em.createQuery("from Flight f where " +
                "f.airplane.model = :model and f.airline.name <> :airline ", Flight.class);
        flightTypedQuery.setParameter("model", "747");
        flightTypedQuery.setParameter("airline", "Star Alliance");
        flights = flightTypedQuery.getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
                Locale.US);
        DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
                Locale.US);

        // d) TODO: All flights leaving before 12pm on 08/07/2009
        System.out.println("Question D:");
        TypedQuery<Flight> query = em.createQuery("from Flight f " +
                "where f.departureDate = :departDate" +
                " and f.departureTime < :departureTime ", Flight.class);
        query.setParameter("departDate", df.parse("08/07/2009"), TemporalType.DATE);
        query.setParameter("departureTime", tf.parse("12:00 PM"), TemporalType.TIME);
        System.out.printf("%-9s%-31s%-31s\n" +
                        "", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getId(), flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();
        em.getTransaction().commit();
        em.close();
    }
}
