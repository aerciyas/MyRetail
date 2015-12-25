package com.my.retail.product;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;


@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Transactional(readOnly = true)
    public Product getProduct(Integer id) throws NotFoundException
    {
        Product product = productDao.getProduct(id);
        if(product != null)
        {
            return product;
        }
        else
        {
            throw new NotFoundException("Could not find data for product with id: " + id);
        }
    }

    @Transactional(readOnly = true)
    public Price getPrice(Integer id) throws NotFoundException
    {
        Price price = productDao.getPrice(id);
        if(price != null)
        {
            return price;
        }
        else
        {
            throw new NotFoundException("Could not find price data for product with id: " + id);
        }
    }

    @Transactional(readOnly = true)
    public Products getProducts(String category) throws NotFoundException
    {
        List<Product> productsList = productDao.getProducts(category);
        if(!productsList.isEmpty())
        {
            return new Products(productsList);
        }
        else
        {
            throw new NotFoundException("Could not find price data for category: " + category);
        }
    }


}