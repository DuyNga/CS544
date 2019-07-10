package Apart;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Amain {

    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        A_Customer customer = new A_Customer("Cus01");
        A_Order order1 = new A_Order(LocalDate.of(2018,5,4));
        A_Order order2 = new A_Order(LocalDate.of(2018,12,2));
        customer.getOrders().add(order1);
        customer.getOrders().add(order2);

        A_OrderLine line1 = new A_OrderLine(10);
        A_OrderLine line2 = new A_OrderLine(20);
        A_OrderLine line3 = new A_OrderLine(30);
        A_OrderLine line4 = new A_OrderLine(40);

        A_Product product1 = new A_Product("pro01","des01");
        A_Product product2 = new A_Product("pro02","des02");
        A_Product product3 = new A_Product("pro03","des03");
        A_Product product4 = new A_Product("pro04","des04");

        order1.getOrderLineList().add(line1);
        order1.getOrderLineList().add(line2);
        order2.getOrderLineList().add(line3);
        order2.getOrderLineList().add(line4);

        line1.setProduct(product1);
        line2.setProduct(product2);
        line3.setProduct(product3);
        line4.setProduct(product4);

        em.persist(customer);
        em.getTransaction().commit();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<A_Customer> customers = em.createQuery("from A_Customer").getResultList();

        customers.forEach(System.out::println);

    }
}
