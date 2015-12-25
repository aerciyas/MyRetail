package com.my.retail.webservice

import com.my.retail.product.Price
import com.my.retail.product.PriceTest
import com.my.retail.product.Product
import com.my.retail.product.ProductService
import com.my.retail.product.ProductTest
import com.my.retail.product.Products
import com.my.retail.product.ProductsTest
import javassist.NotFoundException
import org.junit.Before
import org.junit.Test
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import static org.mockito.Mockito.*

public class ProductControllerTest{

    ProductController productController
    ProductService mockProductService

    Integer testProductId
    String testCategory
    Product testProduct
    Products testProducts
    Price testPrice

    @Before
    public void setUp() throws Exception {

        mockProductService = mock(ProductService.class)

        productController = new ProductController(productService: mockProductService)

        testProductId = 123
        testCategory = "testCategory"
        testProduct = ProductTest.createTestProduct()
        testProducts = ProductsTest.createTestProducts()
        testPrice = PriceTest.createTestPrice()
    }


    @Test
    public void testGetPriceSuccess() throws Exception {

        def expected = new ResponseEntity<String>(testPrice.convertToJson(), RestHeaders.getHeadersNoCacheNoStoreMustRevalidateResponse(), HttpStatus.OK)

        when(mockProductService.getPrice(testProductId)).thenReturn(testPrice)

        def actual = productController.getPrice(testProductId)

        verify(mockProductService).getPrice(testProductId)

        assert actual.statusCode == expected.statusCode
        assert actual.body == expected.body
        assert actual.headers == expected.headers
    }

    @Test
    public void testGetPriceFailWithNotFound() throws Exception {

        def testMessage = "Test NotFoundException error."

        def expected = new ResponseEntity<String>(testMessage, RestHeaders.getHeadersNoCacheNoStoreMustRevalidateResponse(), HttpStatus.NOT_FOUND)

        doThrow(new NotFoundException(testMessage)).when(mockProductService).getPrice(testProductId)

        def actual = productController.getPrice(testProductId)

        verify(mockProductService).getPrice(testProductId)

        assert actual.statusCode == expected.statusCode
        assert actual.body == expected.body
        assert actual.headers == expected.headers

    }

    @Test
    public void testGetPriceSuccessFailWithException() throws Exception {

        def testMessage = "Test Exception error."

        def expected = new ResponseEntity<String>(testMessage, RestHeaders.getHeadersNoCacheNoStoreMustRevalidateResponse(), HttpStatus.INTERNAL_SERVER_ERROR)

        doThrow(new RuntimeException(testMessage)).when(mockProductService).getPrice(testProductId)

        def actual = productController.getPrice(testProductId)

        verify(mockProductService).getPrice(testProductId)

        assert actual.statusCode == expected.statusCode
        assert actual.body == expected.body
        assert actual.headers == expected.headers

    }

    @Test
    public void testGetProductSuccess() throws Exception {

        def expected = new ResponseEntity<String>(testProduct.convertToJson(), RestHeaders.getHeadersPublicMaxAgeOneDayResponse(), HttpStatus.OK)

        when(mockProductService.getProduct(testProductId)).thenReturn(testProduct)

        def actual = productController.getProduct(testProductId)

        verify(mockProductService).getProduct(testProductId)

        assert actual.statusCode == expected.statusCode
        assert actual.body == expected.body
        assert actual.headers == expected.headers

    }

    @Test
    public void testGetProductFailWithNotFound() throws Exception {

        def testMessage = "Test NotFoundException error."

        def expected = new ResponseEntity<String>(testMessage, RestHeaders.getHeadersNoCacheNoStoreMustRevalidateResponse(), HttpStatus.NOT_FOUND)

        doThrow(new NotFoundException(testMessage)).when(mockProductService).getProduct(testProductId)

        def actual = productController.getProduct(testProductId)

        verify(mockProductService).getProduct(testProductId)

        assert actual.statusCode == expected.statusCode
        assert actual.body == expected.body
        assert actual.headers == expected.headers
    }

    @Test
    public void testGetProductFailWithException() throws Exception {

        def testMessage = "Test Exception error."

        def expected = new ResponseEntity<String>(testMessage, RestHeaders.getHeadersNoCacheNoStoreMustRevalidateResponse(), HttpStatus.INTERNAL_SERVER_ERROR)

        doThrow(new RuntimeException(testMessage)).when(mockProductService).getProduct(testProductId)

        def actual = productController.getProduct(testProductId)

        verify(mockProductService).getProduct(testProductId)

        assert actual.statusCode == expected.statusCode
        assert actual.body == expected.body
        assert actual.headers == expected.headers

    }

    @Test
    public void testGetProductsSuccess() throws Exception {

        def expected = new ResponseEntity<String>(testProducts.convertToJson(), RestHeaders.getHeadersPublicMaxAgeOneDayResponse(), HttpStatus.OK)

        when(mockProductService.getProducts(testCategory)).thenReturn(testProducts)

        def actual = productController.getProducts(testCategory)

        verify(mockProductService).getProducts(testCategory)

        assert actual.statusCode == expected.statusCode
        assert actual.body == expected.body
        assert actual.headers == expected.headers

    }

    @Test
    public void testGetProductsFailWithNotFound() throws Exception {

        def testMessage = "Test NotFoundException error."

        def expected = new ResponseEntity<String>(testMessage, RestHeaders.getHeadersNoCacheNoStoreMustRevalidateResponse(), HttpStatus.NOT_FOUND)

        doThrow(new NotFoundException(testMessage)).when(mockProductService).getProducts(testCategory)

        def actual = productController.getProducts(testCategory)

        verify(mockProductService).getProducts(testCategory)

        assert actual.statusCode == expected.statusCode
        assert actual.body == expected.body
        assert actual.headers == expected.headers
    }

    @Test
    public void testGetProductsFailWithException() throws Exception {

        def testMessage = "Test Exception error."

        def expected = new ResponseEntity<String>(testMessage, RestHeaders.getHeadersNoCacheNoStoreMustRevalidateResponse(), HttpStatus.INTERNAL_SERVER_ERROR)

        doThrow(new RuntimeException(testMessage)).when(mockProductService).getProducts(testCategory)

        def actual = productController.getProducts(testCategory)

        verify(mockProductService).getProducts(testCategory)

        assert actual.statusCode == expected.statusCode
        assert actual.body == expected.body
        assert actual.headers == expected.headers

    }

}