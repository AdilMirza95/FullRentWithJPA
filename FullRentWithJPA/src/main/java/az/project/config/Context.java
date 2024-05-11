package az.project.config;


import az.project.dao.impl.CarDaoImpl;
import az.project.dao.impl.CategoryDaoImpl;
import az.project.dao.impl.CustomerDaoImpl;
import az.project.dao.inter.CarDaoInter;
import az.project.dao.inter.CategoryDaoInter;
import az.project.dao.inter.CustomerDaoInter;


public class Context {

    public static CarDaoInter instanceCarDao() {
        return new CarDaoImpl();
    }

  
      public static CategoryDaoInter instanceCategoryDao() {
        return new CategoryDaoImpl();
    }

    public static CustomerDaoInter instanceCustomerDao() {
       return new CustomerDaoImpl();
    }
}
