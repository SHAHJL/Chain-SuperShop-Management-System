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
 * Accept generated by hbm2java
 */
@Entity
@Table(name="accept"
    ,catalog="chain_super_shop"
)
public class Accept  implements java.io.Serializable {


     private Integer accId;
     private Branch branch;
     private Category category;
     private Product product;
     private SubCategory subCategory;
     private int accQty;
     private Date accDate;
     private String accStatus;

    public Accept() {
    }

    public Accept(Branch branch, Category category, Product product, SubCategory subCategory, int accQty, Date accDate, String accStatus) {
       this.branch = branch;
       this.category = category;
       this.product = product;
       this.subCategory = subCategory;
       this.accQty = accQty;
       this.accDate = accDate;
       this.accStatus = accStatus;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="acc_id", unique=true, nullable=false)
    public Integer getAccId() {
        return this.accId;
    }
    
    public void setAccId(Integer accId) {
        this.accId = accId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="branch_reg_id", nullable=false)
    public Branch getBranch() {
        return this.branch;
    }
    
    public void setBranch(Branch branch) {
        this.branch = branch;
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

    
    @Column(name="acc_qty", nullable=false)
    public int getAccQty() {
        return this.accQty;
    }
    
    public void setAccQty(int accQty) {
        this.accQty = accQty;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="acc_date", nullable=false, length=10)
    public Date getAccDate() {
        return this.accDate;
    }
    
    public void setAccDate(Date accDate) {
        this.accDate = accDate;
    }

    
    @Column(name="acc_status", nullable=false, length=45)
    public String getAccStatus() {
        return this.accStatus;
    }
    
    public void setAccStatus(String accStatus) {
        this.accStatus = accStatus;
    }




}

