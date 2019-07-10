package cManyToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Mainc {private static EntityManagerFactory emf;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        C_Student stu1 = new C_Student(1,"Stu01");
        C_Student stu2 = new C_Student(2,"Stu02");

        C_Course co1 =new C_Course("course01");
        C_Course co2 =new C_Course("course02");
        co1.getStudents().add(stu1);
        co1.getStudents().add(stu2);
        co2.getStudents().add(stu1);

        stu1.getCourses().add(co1);
        stu1.getCourses().add(co2);
        stu2.getCourses().add(co1);
        em.persist(co1);
        em.persist(co2);
        em.getTransaction().commit();
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<C_Course> c_courses = em.createQuery("from  C_Course").getResultList();
        System.out.println("------Courses------");
        for (C_Course co:c_courses
             ) {
            System.out.println(co);
        }

        System.out.println("------Students------");
        List<C_Student> c_students =em.createQuery("from C_Student").getResultList();
        for (C_Student stu:c_students
             ) {
            System.out.println(stu);
        }
        em.getTransaction().commit();
    }
}
