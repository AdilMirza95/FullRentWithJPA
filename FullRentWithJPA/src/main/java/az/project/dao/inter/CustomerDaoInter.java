/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package az.project.dao.inter;

import az.project.entity.Customer;
import java.util.List;


public interface CustomerDaoInter {
    void update(Customer cus);
    void insert(Customer cus);
    void delete (int id);
    Customer getCustomerById (int id);
    List<Customer> getAllCustomer();
}
