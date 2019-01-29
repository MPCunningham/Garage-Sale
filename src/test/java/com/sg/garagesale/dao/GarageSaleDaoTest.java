/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.dao;

import com.sg.garagesale.model.Contact;
import com.sg.garagesale.model.FeaturedItems;
import com.sg.garagesale.model.GarageSale;
import com.sg.garagesale.model.User;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author 4oaks
 */
public class GarageSaleDaoTest {
    FeaturedItemsDao itemsDao;

    GarageSaleDao garageSaleDao;
    int garageSaleId = 0;

    public GarageSaleDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        garageSaleDao = ctx.getBean("GarageSaleDao", GarageSaleDao.class);
        itemsDao = ctx.getBean("FeaturedItemsDao", FeaturedItemsDao.class);
        itemsDao.reset();
        garageSaleDao.reset();
        
       

        GarageSale sale = new GarageSale();
        sale.setAddress("123");
        sale.setCity("Minneapolis");
        sale.setState("MN");
        sale.setZipCode("55555");
        garageSaleDao.addGarageSale(sale);
        garageSaleId = sale.getGarageSaleId();

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addGarageSale method, of class GarageSaleDao.
     */
    @Test
    public void testAddGetGarageSale() {

        GarageSale test = garageSaleDao.getGarageSale(garageSaleId);

        assertEquals(test.getAddress(), "123");
        assertEquals(test.getCity(), "Minneapolis");
        assertEquals(test.getZipCode(), "55555");
        assertEquals(test.getState(), "MN");
    }

    @Test
    public void testAddGetGarageSaleByCity() {

        List<GarageSale> saleList = garageSaleDao.getGarageSaleByCity("Minneapolis");

        GarageSale test = saleList.get(0);

        assertEquals(1, saleList.size());
        assertEquals("123", test.getAddress());
        assertEquals("Minneapolis", test.getCity());
        assertEquals("55555", test.getZipCode());
        assertEquals("MN", test.getState());
    }

    @Test
    public void testAddGetGarageSaleByState() {
        List<GarageSale> saleList = garageSaleDao.getGarageSaleByState("MN");
        assertEquals(1, saleList.size());
        GarageSale test = saleList.get(0);
        assertEquals("123", test.getAddress());
        assertEquals("Minneapolis", test.getCity());
        assertEquals("55555", test.getZipCode());
        assertEquals("MN", test.getState());

    }

    @Test
    public void testAddGetGarageSaleByZip() {
        List<GarageSale> saleList = garageSaleDao.getGarageSaleByZip("55555");
        assertEquals(1, saleList.size());
        GarageSale test = saleList.get(0);
        assertEquals("123", test.getAddress());
        assertEquals("Minneapolis", test.getCity());
        assertEquals("55555", test.getZipCode());
        assertEquals("MN", test.getState());

    }

    /**
     * Test of deleteGarageSale method, of class GarageSaleDao.
     */
    @Test
    public void testDeleteGarageSale() {

        garageSaleDao.deleteGarageSale(garageSaleId);

        GarageSale test = garageSaleDao.getGarageSale(garageSaleId);

        assertNull(test);
    }

    /**
     * Test of updateGarageSale method, of class GarageSaleDao.
     */
    @Test
    public void testUpdateGarageSale() {

        GarageSale test = garageSaleDao.getGarageSale(garageSaleId);

        test.setAddress("111");
        test.setCity("test");
        test.setZipCode("11111");
        test.setState("WI");

        garageSaleDao.updateGarageSale(test);

        assertEquals(test.getAddress(), "111");
        assertEquals(test.getCity(), "test");
        assertEquals(test.getZipCode(), "11111");
        assertEquals(test.getState(), "WI");
    }

    /**
     * Test of getAllGarageSales method, of class GarageSaleDao.
     */
    @Test
    public void testGetAllGarageSales() {

        List<GarageSale> saleList = garageSaleDao.getAllGarageSales();

        assertEquals(saleList.size(), 1);

    }

}
