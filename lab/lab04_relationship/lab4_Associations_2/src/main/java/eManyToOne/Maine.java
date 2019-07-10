package eManyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Maine {

    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        E_Reservation reservation = new E_Reservation(LocalDate.parse("2019-02-01"));
        E_Reservation reservation1 = new E_Reservation(LocalDate.parse("2019-02-02"));
        E_Book book = new E_Book("Book01");
        reservation.setBook(book);
        reservation1.setBook(book);
        em.persist(reservation);
        em.persist(reservation1);
        em.getTransaction().commit();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<E_Reservation> reservations =
                em.createQuery("from E_Reservation").getResultList();
        for (E_Reservation res:reservations
             ) {
            System.out.println(res);
        }
        em.getTransaction().commit();
    }
}
