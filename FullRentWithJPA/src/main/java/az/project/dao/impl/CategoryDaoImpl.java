/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.project.dao.impl;

import az.project.config.AbstractDao;
import az.project.dao.inter.CategoryDaoInter;
import az.project.entity.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ADIL
 */
public class CategoryDaoImpl extends AbstractDao implements CategoryDaoInter{

    @Override
    public void update(Category cat) {
       EntityManager em = createEM();
       em.getTransaction().begin();
       em.merge(cat);
       em.getTransaction().commit();
       closeEM(em);
    }

    @Override
    public void insert(Category cat) {
        EntityManager em = createEM();
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
        closeEM(em);
    }

    @Override
    public void delete(int id) {
        EntityManager em = createEM();
        Category cat = em.find(Category.class, id);
        em.getTransaction().begin();
        em.remove(cat);
        em.getTransaction().commit();
        closeEM(em);
        
    }

    @Override
    public Category getCategoryById(int id) {
        EntityManager em = createEM();
        Query q = em.createQuery("Select c from Category c where c.categoryId = :categoryId");
        q.setParameter("categoryId", id);
        Category cat = (Category) q.getSingleResult();
        closeEM(em);
        return cat;       
    }

    @Override
    public List<Category> getAllCategory() {
        EntityManager em = createEM();
        Query q = em.createNamedQuery("Category.findAll");
        List<Category> cat = q.getResultList();
        closeEM(em);
        return cat;
    }
    
}
