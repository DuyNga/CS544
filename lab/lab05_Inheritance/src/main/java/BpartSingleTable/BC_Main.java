package BpartSingleTable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class BC_Main {

    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        BC_Customer customer = new BC_Customer("Cus01");
        BC_Order order1 = new BC_Order(LocalDate.of(2018,5,4));
        BC_Order order2 = new BC_Order(LocalDate.of(2018,12,2));
        customer.getOrders().add(order1);
        customer.getOrders().add(order2);

        BC_OrderLine line1 = new BC_OrderLine(10);
        BC_OrderLine line2 = new BC_OrderLine(20);
        BC_OrderLine line3 = new BC_OrderLine(30);
        BC_OrderLine line4 = new BC_OrderLine(40);
        BC_OrderLine line5 = new BC_OrderLine(50);
        BC_OrderLine line6 = new BC_OrderLine(60);

        BC_Product product1 = new BC_CD("pro01","artist01");
        BC_Product product2 = new BC_DVD("pro02","genre02");
        BC_Product product3 = new BC_Book("pro03","title03");
        BC_Product product4 = new BC_CD("pro04","artist04");
        BC_Product product5 = new BC_DVD("pro05","genre05");
        BC_Product product6 = new BC_Book("pro06","title06");

        order1.getOrderLines().add(line1);
        order1.getOrderLines().add(line2);
        order1.getOrderLines().add(line3);
        order2.getOrderLines().add(line4);
        order2.getOrderLines().add(line5);
        order2.getOrderLines().add(line6);

        line1.setProduct(product1);
        line2.setProduct(product2);
        line3.setProduct(product3);
        line4.setProduct(product4);
        line5.setProduct(product5);
        line6.setProduct(product6);

        em.persist(customer);
        em.getTransaction().commit();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<BC_Customer> customers = em.createQuery("from BC_Customer").getResultList();

        customers.forEach(System.out::println);
    }
}
