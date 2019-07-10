package edu.mum.cs544;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;

public class StudentService {
	private StudentDAO studentdao;
	private EntityManagerFactory entityManagerFactory;

	public StudentService() {
		studentdao = new StudentDAO();
	}

	public StudentService(ServletContext servletContext) {
		this.entityManagerFactory = (EntityManagerFactory) servletContext.getAttribute("entityManagerFactory");
		this.studentdao = new StudentDAO(entityManagerFactory);
	}

	public Student getStudent(long studentid) {
		return studentdao.load(studentid);
	}
}
