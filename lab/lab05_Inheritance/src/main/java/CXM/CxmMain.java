package CXM;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CxmMain {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Patient patient = new Patient("name", "street","zip","city");
        Appointment appointment = new Appointment("2019/02/01");
        Payment payment = new Payment("2019/03/02",100);
        Doctor doctor = new Doctor("Eye","FirstName","LastName");
        appointment.setPatient(patient);
        appointment.setPayment(payment);
        appointment.setDoctor(doctor);
        em.persist(appointment);
        em.getTransaction().commit();
    }
}
