/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.dao;

import com.sg.garagesale.model.Contact;
import com.sg.garagesale.model.FeaturedItems;
import com.sg.garagesale.model.GarageSale;
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
 * @author LENOVO USER
 */
public class FeaturedItemsDaoTest {

    FeaturedItemsDao itemsDao;
    GarageSaleDao garageDao;
    int garageSaleId = 0;
    int itemId = 0;

    public FeaturedItemsDaoTest() {
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

        itemsDao = ctx.getBean("FeaturedItemsDao", FeaturedItemsDao.class);
        garageDao = ctx.getBean("GarageSaleDao", GarageSaleDao.class);

        itemsDao.reset();
        garageDao.reset();

        GarageSale garageSale = new GarageSale();

        garageSale.setAddress("3132");
        garageSale.setCity("Minneapolis");
        garageSale.setState("MN");
        garageSale.setZipCode("55655");
        garageDao.addGarageSale(garageSale);
        garageSaleId = garageSale.getGarageSaleId();

        FeaturedItems item = new FeaturedItems();
        item.setItemCategory("Kids");
        item.setItemDescription("Shoe");
        item.setItemName("Boot");
        item.setGarageSaleId(garageSaleId);
        itemsDao.addItem(item);
        itemId = item.getItemId();

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addItem method, of class FeaturedItemsDao.
     */
    @Test
    public void testAddGetItem() {

        FeaturedItems fromDao = itemsDao.getItem(itemId);

        assertEquals(fromDao.getItemCategory(), "Kids");
        assertEquals(fromDao.getItemDescription(), "Shoe");
        assertEquals(fromDao.getItemName(), "Boot");
    }

    /**
     * Test of deleteItem method, of class FeaturedItemsDao.
     */
    @Test
    public void testDeleteItem() {

        itemsDao.deleteItem(itemId);

        FeaturedItems fromDao = itemsDao.getItem(itemId);
        assertNull(fromDao);
    }

    /**
     * Test of updateItem method, of class FeaturedItemsDao.
     */
    @Test
    public void testUpdateItem() {
        FeaturedItems fromDao = itemsDao.getItem(itemId);

        fromDao.setItemCategory("Clothing");
        fromDao.setItemDescription("Clothes");
        fromDao.setItemName("Pants");

        itemsDao.updateItem(fromDao);

        assertEquals(fromDao.getItemCategory(), "Clothing");
        assertEquals(fromDao.getItemDescription(), "Clothes");
        assertEquals(fromDao.getItemName(), "Pants");

    }

    /**
     * Test of getAllItems method, of class FeaturedItemsDao.
     */
    @Test
    public void testGetAllItems() {
        List<FeaturedItems> itemList = itemsDao.getAllItems();

        assertEquals(1, itemList.size());

        FeaturedItems fromDao = itemList.get(0);

        assertEquals(fromDao.getItemCategory(), "Kids");
        assertEquals(fromDao.getItemDescription(), "Shoe");
        assertEquals(fromDao.getItemName(), "Boot");

    }

    @Test
    public void testToGetItemByGarageSale() {

        List<FeaturedItems> itemList = itemsDao.getItemsByGarageSale(garageSaleId);

        FeaturedItems fromDao = itemList.get(0);

        assertEquals(fromDao.getItemCategory(), "Kids");
        assertEquals(fromDao.getItemDescription(), "Shoe");
        assertEquals(fromDao.getItemName(), "Boot");
    }

}
