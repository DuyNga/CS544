package main;

import domain.School;
import domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SchoolApp {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {

        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        School school = new School("School01");
        Student student = new Student("stu01","Student 01", 21);
        Student student1 = new Student("stu02","Student 02", 20);
        school.addStudent("stu03", student);
        school.addStudent("stu02", student1);
        em.persist(school);
        em.getTransaction().commit();

        em = emf.createEntityManager();

        em.getTransaction().begin();
        List<School> schools = em.createQuery("from School", School.class).getResultList();
        for (School school1 : schools) {
            System.out.println(school1);
        }
        em.getTransaction().commit();
    }
}
