package aOneToManyDepEmp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Maina {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        A_Department department = new A_Department("Dep01");
        A_Department department1 = new A_Department("Dep02");
        A_Employee employee1 = new A_Employee("Emp01");
        A_Employee employee2 = new A_Employee("Emp02");
        department.addEmployee(employee1);
        department.addEmployee(employee2);
        em.persist(department);
        em.persist(department1);
        em.getTransaction().commit();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<A_Department> departments =
                em.createQuery("from A_Department", A_Department.class).getResultList();
        em.getTransaction().commit();

        for (A_Department dept : departments
        ) {
            System.out.println(dept);
        }
    }
}
