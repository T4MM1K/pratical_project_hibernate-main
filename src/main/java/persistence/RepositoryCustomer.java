package persistence;

import java.util.List;
import javax.persistence.EntityManager;
import model.Customers;
import util.DBUtil;

public class RepositoryCustomer {

    private EntityManager em;

    public RepositoryCustomer() {
        em = DBUtil.getEntityManager();
    }


    public List<Customers> listAllCustomers() {
        return em.createQuery("FROM Customers")
                .getResultList();
    }

    public void saveCustomer(Customers customer) {
        try {
            em.getTransaction().begin();
            this.em.persist(customer);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    public long listTotalOfCustomers() {
        String sql = "SELECT COUNT(customerId) FROM Customers";
        return em.createQuery(sql, Long.class)
                .getSingleResult();
    }


}
