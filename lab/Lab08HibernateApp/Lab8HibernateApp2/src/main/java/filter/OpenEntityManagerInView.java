package filter;

import util.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "OpenEntityManagerInView", urlPatterns = "/*")
public class OpenEntityManagerInView implements Filter {
    private EntityManagerFactory emf;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        emf = (EntityManagerFactory) filterConfig.getServletContext().getAttribute("entityManagerFactory");
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        EntityManager em = EntityManagerHelper.getCurrent(emf);
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            em.getTransaction().begin();
            chain.doFilter(req, resp);
            em.getTransaction().commit();
        } catch (RuntimeException ex) {
            try {
                ex.printStackTrace();
                tx.rollback();
            } catch (RuntimeException rbEx) {
                System.out.println("Could not rollback transaction " + rbEx);
                rbEx.printStackTrace();
            }
            throw ex;
        } finally {
            em.close();
        }
    }
}