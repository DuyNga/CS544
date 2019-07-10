package bManyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Mainb {

    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        B_Book b_book = new B_Book("book01");
        B_Book b_book1 = new B_Book("book02");
        B_Publisher publisher = new B_Publisher("publisher01");
        b_book.setPublisher(publisher);
        b_book1.setPublisher(publisher);
        em.persist(b_book);
        em.persist(b_book1);
        em.getTransaction().commit();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<B_Book> b_books = em.createQuery("from B_Book").getResultList();
        for (B_Book boo: b_books
             ) {
            System.out.println(boo);
        }

    }
}
