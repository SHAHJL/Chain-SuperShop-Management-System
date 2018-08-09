package com.shah.chainsupershop.domain;
// Generated Jul 20, 2018 9:29:53 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Purchase generated by hbm2java
 */
@Entity
@Table(name="purchase"
    ,catalog="chain_super_shop"
)
public class Purchase  implements java.io.Serializable {


     private Integer purId;
     private Category category;
     private Product product;
     private SubCategory subCategory;
     private Vendor vendor;
     private Date purDate;
     private double purPrice;
     private int purQty;
     private String purDesc;

    public Purchase() {
    }

    public Purchase(Category category, Product product, SubCategory subCategory, Vendor vendor, Date purDate, double purPrice, int purQty, String purDesc) {
       this.category = category;
       this.product = product;
       this.subCategory = subCategory;
       this.vendor = vendor;
       this.purDate = purDate;
       this.purPrice = purPrice;
       this.purQty = purQty;
       this.purDesc = purDesc;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="pur_id", unique=true, nullable=false)
    public Integer getPurId() {
        return this.purId;
    }
    
    public void setPurId(Integer purId) {
        this.purId = purId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cat_id", nullable=false)
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id", nullable=false)
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="sub_cat_id", nullable=false)
    public SubCategory getSubCategory() {
        return this.subCategory;
    }
    
    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vendor_id", nullable=false)
    public Vendor getVendor() {
        return this.vendor;
    }
    
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="pur_date", nullable=false, length=10)
    public Date getPurDate() {
        return this.purDate;
    }
    
    public void setPurDate(Date purDate) {
        this.purDate = purDate;
    }

    
    @Column(name="pur_price", nullable=false, precision=22, scale=0)
    public double getPurPrice() {
        return this.purPrice;
    }
    
    public void setPurPrice(double purPrice) {
        this.purPrice = purPrice;
    }

    
    @Column(name="pur_qty", nullable=false)
    public int getPurQty() {
        return this.purQty;
    }
    
    public void setPurQty(int purQty) {
        this.purQty = purQty;
    }

    
    @Column(name="pur_desc", nullable=false, length=45)
    public String getPurDesc() {
        return this.purDesc;
    }
    
    public void setPurDesc(String purDesc) {
        this.purDesc = purDesc;
    }




}

