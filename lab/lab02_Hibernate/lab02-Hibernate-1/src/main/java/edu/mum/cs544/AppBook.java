package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppBook {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        // Create new instance of Book and set values in it
        Book book1 = new Book("Me Before You", "S-123", "Author1", 100,
                sdf.parse("1999/03/02"));
        System.out.println(book1.getPublish_date());
        // save the Book
        em.persist(book1);
        // Create new instance of Book and set values in it
        book1 = new Book("Java Persistence API (JPA) Step By Step", "S-124", "Author2", 150,
                sdf.parse("1998/04/01"));
        // save the Book
        em.persist(book1);
        // Create new instance of Book and set values in it
        book1 = new Book("Object Relational Mapping (ORM) Step By Step", "S-125", "Author3", 200,
                sdf.parse("1997/05/03"));
        // save the Book
        em.persist(book1);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all Books
        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        List<Book> BookList = query.getResultList();
        System.out.println("        *********  After save **********");
        for (Book book : BookList) {
            System.out.println(book);
        }
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all Books
        query = em.createQuery("from Book", Book.class);
        BookList = query.getResultList();
        for (Book book : BookList) {
            switch (book.getId()){
                case 1:
                    book.setTitle("Me Before You UPDATE");
                    book.setPrice(110);
                    em.merge(book);
                    break;
                case 2:
                    em.remove(book);
                    break;
            }
        }
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all Books
        query = em.createQuery("from Book", Book.class);
        BookList = query.getResultList();
        System.out.println("        *********  After update **********");
        for (Book book : BookList) {
            System.out.println(book);
        }
        em.getTransaction().commit();
        em.close();

        TimeUnit.SECONDS.sleep(30);
        System.out.println("DONE");
    }
}

