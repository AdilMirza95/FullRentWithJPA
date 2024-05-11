 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.project.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ADIL
 */
@Entity
@Table(name = "car")
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findByCarId", query = "SELECT c FROM Car c WHERE c.carId = :carId"),
    @NamedQuery(name = "Car.findByBrand", query = "SELECT c FROM Car c WHERE c.brand = :brand"),
    @NamedQuery(name = "Car.findByModel", query = "SELECT c FROM Car c WHERE c.model = :model"),
    @NamedQuery(name = "Car.findByYear", query = "SELECT c FROM Car c WHERE c.year = :year"),
    @NamedQuery(name = "Car.findByDayofprice", query = "SELECT c FROM Car c WHERE c.dayofprice = :dayofprice")})
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "car_id")
    private Integer carId;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private Integer year;
    @Column(name = "dayofprice")
    private Integer dayofprice;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne
    private Category category;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    private Customer customer;

    public Car() {
    }

    public Car(Integer carId) {
        this.carId = carId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDayofprice() {
        return dayofprice;
    }

    public void setDayofprice(Integer dayofprice) {
        this.dayofprice = dayofprice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categoryId) {
        this.category = categoryId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customerId) {
        this.customer = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carId != null ? carId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.carId == null && other.carId != null) || (this.carId != null && !this.carId.equals(other.carId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Car{" + "carId=" + carId + ", brand=" + brand + ", model=" + model + ", year=" + year + ", dayofprice=" + dayofprice + ", category=" + category + ", customer=" + customer + '}';
    }

    
    
}
