package com.searchhub.services.ProductBackendDBHandlerService.Controller;

import com.searchhub.services.ProductBackendDBHandlerService.Entity.Webpages;
import com.searchhub.services.ProductBackendDBHandlerService.Repository.WebpageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WebpageController {

    //Instance of the Jpa Repository for the webpage entity
    @Autowired
    private WebpageRepository webpageRepository;

    // Request mapping for getting a list of all the webpages
    @RequestMapping("/webpage/get")
    public List<Webpages> getListOfWebpages(){
        return webpageRepository.findAll();
    }

    // Request mapping for creating a new webpage
    @RequestMapping(method= RequestMethod.POST, value = "/webpage/post")
    public void insertWebpage(@RequestBody Webpages webpages){
        webpageRepository.save(webpages);
    }

    // Request for getting a specific webpage based on the productid (foreign key)
    @RequestMapping(method = RequestMethod.GET, value = "/webpage/get/{productid}")
    public List<Webpages> getListOfRetailersForProduct(@PathVariable("productid") BigInteger productid){
        List<Webpages> resultingWebpages = new ArrayList<>();
        List<Webpages> webpagesList = webpageRepository.findAll();
        for (Webpages x : webpagesList){
            if (x.getProductid().equals(productid)){
                resultingWebpages.add(x);
            }
        }
        return resultingWebpages;
    }

    // Request mapping for deleting a specific webpage based on the id
    @RequestMapping(method = RequestMethod.DELETE, value = "/webpage/delete/{id}")
    public void removeWebpage(@PathVariable("id")BigInteger id){
        webpageRepository.deleteById(id);
    }
}
