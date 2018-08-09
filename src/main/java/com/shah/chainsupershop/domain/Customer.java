package com.shah.chainsupershop.domain;
// Generated Jul 20, 2018 9:29:53 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name="customer"
    ,catalog="chain_super_shop"
)
public class Customer  implements java.io.Serializable {


     private Integer customerId;
     private String customerName;
     private String customerAddress;
     private String customerEmail;
     private int customerPhone;
     private String orderDate;
     private Set<Sales> saleses = new HashSet<Sales>(0);

    public Customer() {
    }

	
    public Customer(String customerName, String customerAddress, String customerEmail, int customerPhone, String orderDate) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.orderDate = orderDate;
    }
    public Customer(String customerName, String customerAddress, String customerEmail, int customerPhone, String orderDate, Set<Sales> saleses) {
       this.customerName = customerName;
       this.customerAddress = customerAddress;
       this.customerEmail = customerEmail;
       this.customerPhone = customerPhone;
       this.orderDate = orderDate;
       this.saleses = saleses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="customer_id", unique=true, nullable=false)
    public Integer getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    
    @Column(name="customer_name", nullable=false, length=45)
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    
    @Column(name="customer_address", nullable=false, length=45)
    public String getCustomerAddress() {
        return this.customerAddress;
    }
    
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    
    @Column(name="customer_email", nullable=false, length=45)
    public String getCustomerEmail() {
        return this.customerEmail;
    }
    
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    
    @Column(name="customer_phone", nullable=false)
    public int getCustomerPhone() {
        return this.customerPhone;
    }
    
    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }

    
    @Column(name="order_date", nullable=false, length=45)
    public String getOrderDate() {
        return this.orderDate;
    }
    
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
    public Set<Sales> getSaleses() {
        return this.saleses;
    }
    
    public void setSaleses(Set<Sales> saleses) {
        this.saleses = saleses;
    }




}


