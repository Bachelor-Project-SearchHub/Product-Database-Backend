package com.searchhub.services.ProductBackendDBHandlerService.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;
import java.sql.Blob;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Products {
    @Id
    private BigInteger id;
    private String productname;
    private String picture;

    public Products() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
