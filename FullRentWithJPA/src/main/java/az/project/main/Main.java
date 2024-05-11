/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.project.main;

import az.project.config.AbstractDao;
import static az.project.config.AbstractDao.emf;
import az.project.config.Context;
import az.project.dao.inter.CarDaoInter;
import az.project.entity.Car;
import az.project.entity.Category;
import az.project.entity.Customer;
import java.util.List;

/**
 *
 * @author ADIL
 */
public class Main {
    public static void main(String[] args) {
        
        List<Customer> list  = Context.instanceCustomerDao().getAllCustomer();
        for(Customer cus:list) {
            System.out.println(cus);
        }
        
        AbstractDao.closeEMF(emf);
    }
}
