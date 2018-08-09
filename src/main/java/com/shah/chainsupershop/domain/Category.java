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
 * Category generated by hbm2java
 */
@Entity
@Table(name="category"
    ,catalog="chain_super_shop"
)
public class Category  implements java.io.Serializable {


     private Integer catId;
     private String catName;
     private String catDesc;
     private String imgPath;
     private Set<Distribution> distributions = new HashSet<Distribution>(0);
     private Set<Purchase> purchases = new HashSet<Purchase>(0);
     private Set<Accept> accepts = new HashSet<Accept>(0);
     private Set<Product> products = new HashSet<Product>(0);
     private Set<SubCategory> subCategories = new HashSet<SubCategory>(0);

    public Category() {
    }

	
    public Category(String catName, String catDesc) {
        this.catName = catName;
        this.catDesc = catDesc;
    }
    public Category(String catName, String catDesc, String imgPath, Set<Distribution> distributions, Set<Purchase> purchases, Set<Accept> accepts, Set<Product> products, Set<SubCategory> subCategories) {
       this.catName = catName;
       this.catDesc = catDesc;
       this.imgPath = imgPath;
       this.distributions = distributions;
       this.purchases = purchases;
       this.accepts = accepts;
       this.products = products;
       this.subCategories = subCategories;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="cat_id", unique=true, nullable=false)
    public Integer getCatId() {
        return this.catId;
    }
    
    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    
    @Column(name="cat_name", nullable=false, length=45)
    public String getCatName() {
        return this.catName;
    }
    
    public void setCatName(String catName) {
        this.catName = catName;
    }

    
    @Column(name="cat_desc", nullable=false, length=45)
    public String getCatDesc() {
        return this.catDesc;
    }
    
    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }

    
    @Column(name="img_path", length=45)
    public String getImgPath() {
        return this.imgPath;
    }
    
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
    public Set<Distribution> getDistributions() {
        return this.distributions;
    }
    
    public void setDistributions(Set<Distribution> distributions) {
        this.distributions = distributions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
    public Set<Purchase> getPurchases() {
        return this.purchases;
    }
    
    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
    public Set<Accept> getAccepts() {
        return this.accepts;
    }
    
    public void setAccepts(Set<Accept> accepts) {
        this.accepts = accepts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
    public Set<SubCategory> getSubCategories() {
        return this.subCategories;
    }
    
    public void setSubCategories(Set<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }




}


