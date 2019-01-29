///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sg.garagesale.dao;
//
//import com.sg.garagesale.model.Role;
//import java.util.List;
//import javax.sql.DataSource;
//import org.junit.After;
//import org.junit.AfterClass;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;
//
///**
// *
// * @author macam
// */
//public class RoleDaoTest {
//    
//    RoleDaoDB dao;
//    
//    public RoleDaoTest() {
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
//        
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
//        JdbcTemplate jdbc = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
//
//        
//        
//        dao = new RoleDaoDB();
//        dao.setJdbcTemplate(jdbc);
//        
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getRoleById method, of class RoleDao.
//     */
//    @Test
//    public void testAddGetRole() {
//        Role role = new Role();
//        role.setRoleName("Admin");
//        
//        dao.createRole(role);
//        
//        
//        Role idFromDao = dao.getRoleById(role.getRoleId());
//        assertEquals(idFromDao, role);
//        assertEquals(idFromDao.getRoleId(), role.getRoleId());
//        assertEquals(idFromDao.getRoleName(), role.getRoleName());
//        
//        Role nameFromDao = dao.getRoleByName(role.getRoleName());
//        assertEquals(nameFromDao, role);
//        assertEquals(nameFromDao.getRoleId(), role.getRoleId());
//        assertEquals(nameFromDao.getRoleName(), role.getRoleName());
//
//    }
//
//    /**
//     * Test of getAllRoles method, of class RoleDao.
//     */
//    @Test
//    public void testGetAllRoles() {
//        Role roleOne = new Role();
//        roleOne.setRoleName("Admin");
//        
//        Role roleTwo = new Role();
//        roleTwo.setRoleName("Moderator");
//        
//        dao.createRole(roleOne);
//        dao.createRole(roleTwo);
//        
//        List<Role> roles = dao.getAllRoles();
//        
//        assertEquals(roles.size(), 2);
//        assertEquals(roles.get(0), roleOne);
//        assertEquals(roles.get(1), roleTwo);
//    }
//
//    /**
//     * Test of updateRole method, of class RoleDao.
//     */
//    @Test
//    public void testUpdateRole() {
//        Role role = new Role();
//        role.setRoleName("Moderator");
//        
//        dao.createRole(role);
//        
//        Role fromDao = dao.getRoleById(role.getRoleId());
//        assertEquals(fromDao, role);
//        
//        role.setRoleName("Admin");
//        dao.updateRole(role);
//        
//        fromDao = dao.getRoleById(role.getRoleId());
//        assertEquals(fromDao, role);
//    }
//
//    /**
//     * Test of deleteRole method, of class RoleDao.
//     */
//    @Test
//    public void testDeleteRole() {
//        Role role = new Role();
//        role.setRoleName("Moderator");
//        
//        dao.createRole(role);
//        
//        Role fromDao = dao.getRoleById(role.getRoleId());
//        assertEquals(fromDao, role);
//        
//        dao.deleteRole(role.getRoleId());
//        
//        fromDao = dao.getRoleById(role.getRoleId());
//        
//        assertNull(fromDao);
//    }
//
//    
//}
