package com.my.retail.product

import org.hibernate.Criteria
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.junit.Before
import org.junit.Test

import static org.mockito.Mockito.*

public class ProductDaoImplTest {

    ProductDao productDao
    Session mockSession
    Criteria mockCriteria
    SessionFactory mockSessionFactory

    Integer testProductId

    @Before
    public void setUp(){

        mockSession = mock(Session.class)
        mockSessionFactory = mock(SessionFactory.class)
        mockCriteria  = mock(Criteria.class)

        productDao = new ProductDaoImpl(sessionFactory: mockSessionFactory)

        testProductId = 123
    }

    @Test
    public void testGetPrice() throws Exception {

        def testPrice = PriceTest.createTestPrice()

        def expected = testPrice

        when(mockSessionFactory.getCurrentSession()).thenReturn(mockSession)
        when(mockSession.createCriteria(Price.class)).thenReturn(mockCriteria)
        when(mockCriteria.uniqueResult()).thenReturn(testPrice)

        def actual = productDao.getPrice(testProductId)

        verify(mockSessionFactory).getCurrentSession()
        verify(mockSession).createCriteria(Price.class)
        verify(mockCriteria).uniqueResult()

        assert actual == expected

    }

    @Test
    public void testGetProduct() throws Exception {

        def testProduct = ProductTest.createTestProduct()

        def expected = testProduct

        when(mockSessionFactory.getCurrentSession()).thenReturn(mockSession)
        when(mockSession.createCriteria(Product.class)).thenReturn(mockCriteria)
        when(mockCriteria.uniqueResult()).thenReturn(testProduct)

        def actual = productDao.getProduct(testProductId)

        verify(mockSessionFactory).getCurrentSession()
        verify(mockSession).createCriteria(Product.class)
        verify(mockCriteria).uniqueResult()

        assert actual == expected
    }

    @Test
    public void testGetProducts() throws Exception {

        def testProducts = ProductsTest.createTestProducts().products

        def expected = testProducts

        when(mockSessionFactory.getCurrentSession()).thenReturn(mockSession)
        when(mockSession.createCriteria(Product.class)).thenReturn(mockCriteria)
        when(mockCriteria.list()).thenReturn(testProducts)

        def actual = productDao.getProducts("testCategory")

        verify(mockSessionFactory).getCurrentSession()
        verify(mockSession).createCriteria(Product.class)
        verify(mockCriteria).list()

        assert actual == expected
    }
}