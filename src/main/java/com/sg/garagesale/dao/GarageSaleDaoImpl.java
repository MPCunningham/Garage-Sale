/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.dao;

import com.sg.garagesale.model.GarageSale;
import com.sg.garagesale.model.Role;
import com.sg.garagesale.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author 4oaks
 */
public class GarageSaleDaoImpl implements GarageSaleDao {

    private static final String SQL_DELETE_GARAGESALE
            = "delete from garagesales where GarageSaleID = ?";
    private static final String SQL_SELECT_GARAGESALE
            = "select * from garagesales where GarageSaleID = ?";
    private static final String SQL_SELECT_ALL_GARAGESALES
            = "select * from garagesales";
    private static final String SQL_DELETE_ALL_GARAGESALES
            = "delete from garagesales";
    private static final String SQL_INSERT_USER_GARAGESALES
            = "insert into usergaragesales (GarageSaleID, UserID)"
            + "values (?, ?)";
    private static final String SQL_DELETE_USER_GARAGESALES
            = "delete from usergaragesales where GarageSaleID = ?";
    private static final String SQL_SELECT_USERS_FOR_GARAGESALE
            = "select * from usergaragesales where GarageSaleID = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addGarageSale(GarageSale sale) {

//        final String SQL_INSERT_GARAGESALE
//                = "insert into garagesales (Address, City, ZipCode, State, ContactID)"
//                + "values (?, ?, ?, ?, ?)";




        final String SQL_INSERT_GARAGESALE
            = "insert into garagesales (Address, City, State, ZipCode)"
            + "values (?, ?, ?, ?)";
        jdbcTemplate.update(SQL_INSERT_GARAGESALE, sale.getAddress(), sale.getCity(), sale.getState(), sale.getZipCode());


        int newID = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        sale.setGarageSaleId(newID);

        for (User user : sale.getUserList()) {
            jdbcTemplate.update(SQL_INSERT_USER_GARAGESALES, sale.getGarageSaleId(), user.getUserID());
        }
    }

    @Override
    public void deleteGarageSale(int saleId) {
        jdbcTemplate.update(SQL_DELETE_USER_GARAGESALES, saleId);
        jdbcTemplate.update(SQL_DELETE_GARAGESALE, saleId);
    }

    @Override
    public void updateGarageSale(GarageSale sale) {


        final String SQL_UPDATE_GARAGESALE
            = "update garagesales set Address = ?, City = ?, State = ?, ZipCode = ? where GarageSaleID = ?";
        jdbcTemplate.update(SQL_UPDATE_GARAGESALE, sale.getAddress(), sale.getCity(), sale.getState(), sale.getZipCode(), sale.getGarageSaleId());

        jdbcTemplate.update(SQL_DELETE_USER_GARAGESALES, sale.getGarageSaleId());

        for (User user : sale.getUserList()) {
            jdbcTemplate.update(SQL_INSERT_USER_GARAGESALES, sale.getGarageSaleId(), user.getUserID());
        }
    }

    @Override
    public GarageSale getGarageSale(int saleId) {
        try {
            GarageSale sale = jdbcTemplate.queryForObject(SQL_SELECT_GARAGESALE, new GarageSaleMapper(), saleId);
            sale.setUserList(getUsersForGarageSale(saleId));
            return sale;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<GarageSale> getAllGarageSales() {
        List<GarageSale> saleList = jdbcTemplate.query(SQL_SELECT_ALL_GARAGESALES, new GarageSaleMapper());
        for (GarageSale sale : saleList) {
            sale.setUserList(getUsersForGarageSale(sale.getGarageSaleId()));
        }
        return saleList;
    }

    private List<User> getUsersForGarageSale(int saleId) {
        List<User> users = jdbcTemplate.query(SQL_SELECT_USERS_FOR_GARAGESALE, new UserMapper(), saleId);
        return users;
    }

    @Override
    public void reset() {
        jdbcTemplate.update(SQL_DELETE_ALL_GARAGESALES);
    }

    private static final String SQL_SELECT_GARAGESALES_BY_CITY
            = "select * from garagesales where City=?";

    @Override
    public List<GarageSale> getGarageSaleByCity(String city) {
        return jdbcTemplate.query(SQL_SELECT_GARAGESALES_BY_CITY, new GarageSaleMapper(), city);

    }
    private static final String SQL_SELECT_GARAGESALES_BY_STATE
            = "select * from garagesales where State=?";

    @Override
    public List<GarageSale> getGarageSaleByState(String state) {

        return jdbcTemplate.query(SQL_SELECT_GARAGESALES_BY_STATE, new GarageSaleMapper(), state);
    }
    private static final String SQL_SELECT_GARAGESALES_BY_ZIP
            ="select * from garagesales where ZipCode=?";
    @Override
    public List<GarageSale> getGarageSaleByZip(String zip) {
        return jdbcTemplate.query(SQL_SELECT_GARAGESALES_BY_ZIP, new GarageSaleMapper(),zip);
    }

    private static final class GarageSaleMapper implements RowMapper<GarageSale> {

        @Override
        public GarageSale mapRow(ResultSet rs, int i) throws SQLException, DataAccessException {
            int saleId = 0;

            GarageSale sale = new GarageSale();

            sale.setAddress(rs.getString("Address"));
            sale.setCity(rs.getString("City"));
            sale.setZipCode(rs.getString("ZipCode"));
            sale.setState(rs.getString("State"));

            sale.setGarageSaleId(rs.getInt("GarageSaleID"));

            return sale;

        }
    }


    private static final class GarageMapper implements RowMapper<GarageSale> {

        @Override
        public GarageSale mapRow(ResultSet rs, int i) throws SQLException, DataAccessException {
            GarageSale garageSale = new GarageSale();

            garageSale.setAddress(rs.getString("Address"));
            garageSale.setCity(rs.getString("City"));
            
            garageSale.setState(rs.getString("State"));
            garageSale.setZipCode(rs.getString("ZipCode"));

            return garageSale;


 


    }
    }

    private static final class UserMapper implements RowMapper<User> {

     
        public User mapRow(ResultSet rs, int i) throws SQLException, DataAccessException {
            int userId = 0;

            User users = new User();

            users.setUserName(rs.getString("UserName"));
            users.setUserPassword(rs.getString("UserPassword"));
            users.setUserID(rs.getInt("UserID"));

            return users;

        }
    }

}

