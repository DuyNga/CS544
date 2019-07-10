package dOneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Maind {

    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        D_Customer customer = new D_Customer("Cus01");
        D_Reservation reservation1= new D_Reservation(LocalDate.now());
        D_Reservation reservation2= new D_Reservation(LocalDate.parse("2019-12-20"));
        customer.getReservations().add(reservation1);
        customer.getReservations().add(reservation2);
        em.persist(customer);
        em.getTransaction().commit();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<D_Customer> customers = em.createQuery("from D_Customer").getResultList();
        for (D_Customer cus:customers
             ) {
            System.out.println(cus);
        }
        em.getTransaction().commit();

    }
}
