package main;

import domain.Employee;
import domain.Laptop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeApp {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {

        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Employee employee = new Employee("Emp01", "Add01");
        Laptop laptop1 = new Laptop("Lap01");
        employee.addLaptop(laptop1);
        laptop1 = new Laptop("Lap02");
        employee.addLaptop(laptop1);

        Employee employee1 = new Employee("Emp2", "Add02");
        Laptop laptop = new Laptop("Lap03");
        laptop.setEmployee(employee1);
        em.persist(employee);
        em.persist(laptop);
        em.getTransaction().commit();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Employee> employees = em.createQuery("from Employee", Employee.class).getResultList();
        System.out.println("RESULTS");
        for (Employee employee2 : employees) {
            System.out.println(employee2);
        }
        em.getTransaction().commit();
    }
}
