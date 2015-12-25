package com.my.retail.product;

import com.sun.scenario.effect.impl.prism.PrReflectionPeer;
import javassist.NotFoundException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Product getProduct(Integer id)
    {
        Criteria criteria  = getCurrentSession().createCriteria(Product.class);
        criteria.add(Restrictions.eq("id", id));
        return (Product) criteria.uniqueResult();
    }

    @Override
    public Price getPrice(Integer id)
    {
        Criteria criteria  = getCurrentSession().createCriteria(Price.class);
        criteria.add(Restrictions.eq("id", id));
        return (Price) criteria.uniqueResult();
    }

    @Override
    public List<Product> getProducts(String category)
    {
        Criteria criteria  = getCurrentSession().createCriteria(Product.class);
        criteria.add(Restrictions.eq("category", category));
        return (List<Product>) criteria.list();
    }


    private Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }
}
