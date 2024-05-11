
package az.project.dao.impl;

import az.project.config.AbstractDao;
import az.project.dao.inter.CustomerDaoInter;
import az.project.entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class CustomerDaoImpl extends AbstractDao implements CustomerDaoInter{

    @Override
    public void update(Customer cus) {
        EntityManager em = createEM();
        em.getTransaction().begin();
        em.merge(cus);
        em.getTransaction().commit();
        closeEM(em);        
    }

    @Override
    public void insert(Customer cus) {
        EntityManager em = createEM();
        em.getTransaction().begin();
        em.persist(cus);
        em.getTransaction().commit();
        closeEM(em);
    }

    @Override
    public void delete(int id) {
        EntityManager em = createEM();
        Customer cus = em.find(Customer.class, id);
        em.remove(cus);
        em.getTransaction().commit();
        closeEM(em);      
    }

    @Override
    public Customer getCustomerById(int id) {
       EntityManager em = createEM();
       Query q = em.createQuery("Select  from Customer cus where cus.customerId = :customerId ");
       Customer cus = (Customer) q.setParameter("customerId", id);
       closeEM(em);
       return cus;
        
    }

    @Override
    public List<Customer> getAllCustomer() {
        EntityManager em = createEM();
        Query q = em.createNamedQuery("Customer.findAll");
        List <Customer> list = q.getResultList();
        closeEM(em);
        return list;
    }
    
}
