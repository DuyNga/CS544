package fManyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Mainf {

    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        F_Office office = new F_Office("office01");
        F_Employee employee1 = new F_Employee("Emp01");
        F_Employee employee2 = new F_Employee("Emp02");
        employee1.setOffice(office);
        employee2.setOffice(office);
        em.persist(employee1);
        em.persist(employee2);
        em.getTransaction().commit();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<F_Office> offices = em.createQuery("from F_Office").getResultList();
        for (F_Office off: offices
             ) {
            System.out.println(off);
        }
    }
}
