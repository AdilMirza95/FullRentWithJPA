/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.project.dao.impl;

import az.project.config.AbstractDao;
import az.project.dao.inter.CarDaoInter;
import az.project.entity.Car;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ADIL
 */
public class CarDaoImpl extends AbstractDao implements CarDaoInter {

    @Override
    public void update(Car c) {
        EntityManager em = createEM();
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
        closeEM(em);
    }

    @Override
    public void insert(Car c) {
        EntityManager em = createEM();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        closeEM(em);
    }

    @Override
    public void delete(int id) {
        EntityManager em = createEM();
        Car c = em.find(Car.class, id);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        closeEM(em);
    }

    @Override
    public Car getCarById(int id) {
        EntityManager em = createEM();
        Query q = em.createQuery("Select c from Car c where c.carId= :x");
        q.setParameter("x", id);
        Car c = (Car) q.getSingleResult();
        closeEM(em);
        return c;
    }

    @Override
    public List<Car> getAllCar() {
        EntityManager em = createEM();
        Query q = em.createNamedQuery("Car.findAll");
        List<Car> list = q.getResultList();
        closeEM(em);
        return list;
    }

}
