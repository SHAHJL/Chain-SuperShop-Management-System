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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Vendor generated by hbm2java
 */
@Entity
@Table(name="vendor"
    ,catalog="chain_super_shop"
)
public class Vendor  implements java.io.Serializable {


     private Integer vendorId;
     private User user;
     private String vendorName;
     private String vendorLocation;
     private String vendorType;
     private Set<Purchase> purchases = new HashSet<Purchase>(0);

    public Vendor() {
    }

	
    public Vendor(User user, String vendorName, String vendorLocation, String vendorType) {
        this.user = user;
        this.vendorName = vendorName;
        this.vendorLocation = vendorLocation;
        this.vendorType = vendorType;
    }
    public Vendor(User user, String vendorName, String vendorLocation, String vendorType, Set<Purchase> purchases) {
       this.user = user;
       this.vendorName = vendorName;
       this.vendorLocation = vendorLocation;
       this.vendorType = vendorType;
       this.purchases = purchases;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="vendor_id", unique=true, nullable=false)
    public Integer getVendorId() {
        return this.vendorId;
    }
    
    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="vendor_name", nullable=false, length=45)
    public String getVendorName() {
        return this.vendorName;
    }
    
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    
    @Column(name="vendor_location", nullable=false, length=45)
    public String getVendorLocation() {
        return this.vendorLocation;
    }
    
    public void setVendorLocation(String vendorLocation) {
        this.vendorLocation = vendorLocation;
    }

    
    @Column(name="vendor_type", nullable=false, length=45)
    public String getVendorType() {
        return this.vendorType;
    }
    
    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="vendor")
    public Set<Purchase> getPurchases() {
        return this.purchases;
    }
    
    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }




}

