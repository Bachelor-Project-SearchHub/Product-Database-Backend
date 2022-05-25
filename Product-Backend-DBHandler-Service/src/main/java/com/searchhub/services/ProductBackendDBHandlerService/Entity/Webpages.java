package com.searchhub.services.ProductBackendDBHandlerService.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import java.math.BigInteger;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Webpages {

    @Id
    private BigInteger id;
    private String webpagename;
    private String url;
    private double price;
    private String logo;
    @PrimaryKeyJoinColumn(name = "products")
    private BigInteger productid;

    public Webpages() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getWebpagename() {
        return webpagename;
    }

    public void setWebpagename(String webpagename) {
        this.webpagename = webpagename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    /*public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }*/

    public BigInteger getProductid() {
        return productid;
    }

    public void setProductid(BigInteger productid) {
        this.productid = productid;
    }
}
