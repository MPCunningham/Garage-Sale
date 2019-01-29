///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sg.garagesale.dao;
//
//import com.sg.garagesale.model.User;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// *
// * @author LENOVO USER
// */
//public class UserDaoTest {
//    
//    UserDao dao;
//    //int userId = 0;
//    
//    public UserDaoTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
//        
//        dao = ctx.getBean("UserDao", UserDao.class);
//        
//        dao.reset();
//        
//        User user = new User();
//        user.setUserName("test");
//        user.setUserPassword("password");
//        user.setEnabled(true);
//        dao.addUser(user);
//        userId = user.getUserID();
//        
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of addUser method, of class UserDao.
//     */
//    @Test
//    public void testGetAddUser() {
//        
//        User test = dao.getUser(userId);
//        assertEquals("test", test.getUserName());
//        assertEquals("password", test.getUserPassword());
//        assertEquals(true, test.isEnabled());
//    }
//
//    /**
//     * Test of deleteUser method, of class UserDao.
//     */
//    @Test
//    public void testDeleteUser() {
//        
//        dao.deleteUser(userId);
//        
//        User test = dao.getUser(userId);
//        
//        assertNull(test);
//        
//    }
//
//    /**
//     * Test of updateUser method, of class UserDao.
//     */
//    @Test
//    public void testUpdateUser() {
//        
//        User test = dao.getUser(userId);
//        
//        test.setUserName("test1");
//        test.setUserPassword("password1");
//        test.setEnabled(false);
//        
//        dao.updateUser(test);
//        
//        assertEquals("test1", test.getUserName());
//        assertEquals("password1", test.getUserPassword());
//        assertEquals(false, test.isEnabled());
//    }
//
//    /**
//     * Test of getAllUsers method, of class UserDao.
//     */
//    @Test
//    public void testGetAllUsers() {
//        
//        List<User> userList = dao.getAllUsers();
//        
//        assertEquals(1, userList.size());
//        
//        User test = userList.get(0);
//        
//        assertEquals("test", test.getUserName());
//        assertEquals("password", test.getUserPassword());
//        assertEquals(true, test.isEnabled());
//    }
//   
//}