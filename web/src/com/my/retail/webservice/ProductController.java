package com.my.retail.webservice;

import com.my.retail.product.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("productController")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    ResponseEntity getProduct(@RequestParam(value = "id", required = true) Integer id)
    {
        try
        {
            Product product  = productService.getProduct(id);
            return new ResponseEntity<String>(product.convertToJson(), RestHeaders.getHeadersPublicMaxAgeOneDayResponse(), HttpStatus.OK);
        }
        catch (NotFoundException e)
        {
            return new ResponseEntity<String>(e.getMessage(), RestHeaders.getHeadersNoCacheNoStoreMustRevalidateResponse(), HttpStatus.NOT_FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), RestHeaders.getHeadersNoCacheNoStoreMustRevalidateResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/product/price", method = RequestMethod.GET)
    ResponseEntity getPrice(@RequestParam(value = "id", required = true) Integer id)
    {
        try
        {
            Price price  = productService.getPrice(id);
            return new ResponseEntity<String>(price.convertToJson(), RestHeaders.getHeadersNoCacheNoStoreMustRevalidateResponse(), HttpStatus.OK);
        }
        catch (NotFoundException e)
        {
            return new ResponseEntity<String>(e.getMessage(), RestHeaders.getHeadersNoCacheNoStoreMustRevalidateResponse(), HttpStatus.NOT_FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), RestHeaders.getHeadersNoCacheNoStoreMustRevalidateResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    ResponseEntity getProducts(@RequestParam(value = "category", required = true) String category)
    {
        try
        {
            Products prices  = productService.getProducts(category);
            return new ResponseEntity<String>(prices.convertToJson(), RestHeaders.getHeadersPublicMaxAgeOneDayResponse(), HttpStatus.OK);
        }
        catch (NotFoundException e)
        {
            return new ResponseEntity<String>(e.getMessage(), RestHeaders.getHeadersNoCacheNoStoreMustRevalidateResponse(), HttpStatus.NOT_FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), RestHeaders.getHeadersNoCacheNoStoreMustRevalidateResponse (), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
