package com.my.retail.product

import org.junit.Before
import org.junit.Test

import static org.mockito.Mockito.*


public class ProductServiceImplTest extends GroovyTestCase{
    
    ProductService productService
    ProductDao mockProductDao

    Integer testProductId
    String testCategory
    Product testProduct
    Products testProducts
    Price testPrice

    @Before
    public void setUp() throws Exception {

        mockProductDao = mock(ProductDao.class)

        productService = new ProductServiceImpl(productDao: mockProductDao)

        testProductId = 123
        testCategory = "testCategory"
        testProduct = ProductTest.createTestProduct()
        testProducts = ProductsTest.createTestProducts()
        testPrice = PriceTest.createTestPrice()
    }


    @Test
    public void testGetPriceSuccess() throws Exception {

        def expected = testPrice

        when(mockProductDao.getPrice(testProductId)).thenReturn(testPrice)

        def actual =  productService.getPrice(testProductId)

        verify(mockProductDao).getPrice(testProductId)

        assert actual == expected

    }

    @Test
    public void testGetPriceFail() throws Exception {

        when(mockProductDao.getPrice(testProductId)).thenReturn(null)

        shouldFail({productService.getPrice(testProductId)})

        verify(mockProductDao).getPrice(testProductId)
    }

    @Test
    public void testGetProductSuccess() throws Exception {

        def expected = testProduct

        when(mockProductDao.getProduct(testProductId)).thenReturn(testProduct)

        def actual = productService.getProduct(testProductId)

        verify(mockProductDao).getProduct(testProductId)

        assert actual == expected

    }

    @Test
    public void testGetProductFail() throws Exception {

        when(mockProductDao.getProduct(testProductId)).thenReturn(null)

        shouldFail({productService.getProduct(testProductId)})

        verify(mockProductDao).getProduct(testProductId)
    }

    @Test
    public void testGetProductsSuccess() throws Exception {

        def expected = testProducts

        when(mockProductDao.getProducts(testCategory)).thenReturn(testProducts.products)

        def actual = productService.getProducts(testCategory)

        verify(mockProductDao).getProducts(testCategory)

        assert actual.products[0] == expected.products[0]

    }

    @Test
    public void testGetProductsFail() throws Exception {

        when(mockProductDao.getProducts(testCategory)).thenReturn([])

        shouldFail({productService.getProducts(testCategory)})

        verify(mockProductDao).getProducts(testCategory)
    }

}