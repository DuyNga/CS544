package edu.mum.cs544;

import util.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDAO {

    private EntityManagerFactory entityManagerFactory;
    private Collection<Student> studentlist = new ArrayList<Student>();

    public StudentDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public StudentDAO() {
        Student student = new Student(12345, "Frank", "Brown");
        Course course1 = new Course(1101, "Java", "A");
        Course course2 = new Course(1102, "Math", "B-");
        student.addCourse(course1);
        student.addCourse(course2);
        studentlist.add(student);

    }

    public Student load(long studentid) {
//		for (Student student : studentlist) {
//			if (student.getStudentid() == studentid) {
//				return student;
//			}
//		}
        EntityManager em = EntityManagerHelper.getCurrent(entityManagerFactory);
        return em.find(Student.class, studentid);
    }
}
