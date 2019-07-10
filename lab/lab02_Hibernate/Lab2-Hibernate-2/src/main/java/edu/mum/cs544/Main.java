package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs54444");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all Students
        TypedQuery<Students> query = em.createQuery("from edu.mum.cs544.Students", Students.class);
        List<Students> studentList = query.getResultList();
        System.out.println("        *********  Students from Database **********");
        for (Students student : studentList) {
            System.out.println(student);
        }
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // Save more students
        Students students = new Students(111,"Alpha","alpha@gmail.com","Abc12345");
        em.merge(students);
        students = new Students(222,"Beta","beta@gmail.com","No%password");
        em.merge(students);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all Students
        query = em.createQuery("from edu.mum.cs544.Students", Students.class);
        studentList = query.getResultList();
        System.out.println("        *********  Students from Database after insert more **********");
        for (Students student : studentList) {
            System.out.println(student);
        }
        em.getTransaction().commit();
        em.close();
    }
}

