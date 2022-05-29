package com.searchhub.services.ProductBackendDBHandlerService.Controller;

import com.searchhub.services.ProductBackendDBHandlerService.Entity.Products;
import com.searchhub.services.ProductBackendDBHandlerService.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@CrossOrigin
@RestController
@CrossOrigin
public class ProductController {

    // Instance of JpaRepository for Products entity
    @Autowired
    private ProductRepository productRepository;

    // Request mapping for home page
    @RequestMapping("/product/")
    public String getProductHome(){
        return ("Product Home");
    }

    // Request mapping for get list of products
    @RequestMapping("/product/get")
    public List<Products> getProducts(){
        return productRepository.findAll();
    }

    // Request mapping for getting a specific product based on the product id
    @RequestMapping(method = RequestMethod.GET,value = "/product/get/id/{id}")
    public Products getProduct(@PathVariable("id") BigInteger id ){
        try {
            return productRepository.getById(id);
        } catch (HttpMessageNotWritableException e){
            return null;
        }
    }

    // Request mapping for creating a new product as a JSON Object
    @RequestMapping(method = RequestMethod.POST, value = "/product/post")
    public void insertProduct(@RequestBody Products products){
        productRepository.save(products);
    }

    // Request mapping for deleting a product based on the product id
    @RequestMapping(method = RequestMethod.DELETE,value = "/product/delete/{id}")
    public void removeProduct(@PathVariable("id")BigInteger id){
        productRepository.deleteById(id);
    }

    // Request for getting a product based on the product name
    @RequestMapping(method = RequestMethod.GET, value = "/product/get/name/{productname}")
    public Products getProductBasedOnName(@PathVariable String productname){
        List<Products> listOfProducts = productRepository.findAll();
        Products result = new Products();
        for (Products x : listOfProducts){
            if (x.getProductname().equals(productname)){
                result = x;
            }
        }
        return result;
    }
}
