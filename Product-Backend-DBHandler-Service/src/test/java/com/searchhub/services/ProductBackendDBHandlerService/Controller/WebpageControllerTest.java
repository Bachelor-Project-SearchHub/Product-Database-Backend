package com.searchhub.services.ProductBackendDBHandlerService.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import com.searchhub.services.ProductBackendDBHandlerService.Entity.Products;
import com.searchhub.services.ProductBackendDBHandlerService.Entity.Webpages;
import com.searchhub.services.ProductBackendDBHandlerService.Repository.ProductRepository;
import com.searchhub.services.ProductBackendDBHandlerService.Repository.WebpageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.List;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WebpageControllerTest {
    @InjectMocks
    WebpageController webpageController;

    @Mock
    WebpageRepository webpageRepository;

    @Test
    void testGetWebpage(){
        Webpages webpagesTest1 = new Webpages();
        Webpages webpagesTest2 = new Webpages();
        Webpages webpagesTest3 = new Webpages();
        BigInteger id1 = BigInteger.valueOf(99);
        BigInteger id2 = BigInteger.valueOf(100);
        BigInteger id3 = BigInteger.valueOf(101);
        BigInteger productid = BigInteger.valueOf(204);

        webpagesTest1.setId(id1);
        webpagesTest1.setWebpagename("Webpage Test 1");
        webpagesTest1.setUrl("Webpage URL 1");
        webpagesTest1.setPrice(610);
        webpagesTest1.setLogo("Webpage Logo 1");
        webpagesTest1.setProductid(productid);

        webpagesTest2.setId(id2);
        webpagesTest2.setWebpagename("Webpage Test 2");
        webpagesTest2.setUrl("Webpage URL 2");
        webpagesTest2.setPrice(605);
        webpagesTest2.setLogo("Webpage Logo 2");
        webpagesTest2.setProductid(productid);

        webpagesTest3.setId(id3);
        webpagesTest3.setWebpagename("Webpage Test 3");
        webpagesTest3.setUrl("Webpage URL 3");
        webpagesTest3.setPrice(660);
        webpagesTest3.setLogo("Webpage Logo 3");
        webpagesTest3.setProductid(BigInteger.valueOf(205));

        List<Webpages> webpagesList = new ArrayList<>();
        webpagesList.add(webpagesTest1);
        webpagesList.add(webpagesTest2);

        when(webpageController.getListOfRetailersForProduct(productid)).thenReturn(webpagesList);

        //When
        List<Webpages> result = webpageController.getListOfRetailersForProduct(productid);

        //Then
        assertThat(result.size() == 2);
        assertThat(result.get(0).getWebpagename() == webpagesTest1.getWebpagename());
        assertThat(result.get(1).getWebpagename() == webpagesTest2.getWebpagename());
        assertThat(result.get(0).getProductid().equals(result.get(1).getProductid()));
        assertThat(!result.get(0).getProductid().equals(webpagesTest3.getProductid()));
    }
}