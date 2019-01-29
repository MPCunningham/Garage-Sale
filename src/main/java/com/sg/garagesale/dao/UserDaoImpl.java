/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.dao;

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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LENOVO USER
 */
public class UserDaoImpl implements UserDao {

    private static final String SQL_DELETE_USER
            = "delete from UserTable where UserID = ?";
    private static final String SQL_SELECT_USER
            = "select * from UserTable where UserId = ?";
    private static final String SQL_SELECT_ALLUSERS
            = "select * from UserTable";
    private static final String SQL_DELETE_ALL_USER
            = "delete from usertable";
    private static final String SQL_INSERT_USER_ROLE
            = "insert into userrole (userID,RoleID) values(?,?)";
    private static final String SQL_DELETE_USER_ROLE
            = "delete from userrole where userID=?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        final String SQL_INSERT_USERS = "insert into UserTable (UserName, UserPassword, enabled, ContactName, PhoneNumber, Email)"
                + "values (?, ?, ?, ?, ?, ?)";
        Set<Role> roles = user.getRoles();

        jdbcTemplate.update(SQL_INSERT_USERS, user.getUserName(), user.getUserPassword(), user.isEnabled(), user.getContactName(), user.getPhoneNumber(), user.getEmail());
        int newID = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        user.setUserID(newID);

        if (roles != null) {
            for (Role role : roles) {
                jdbcTemplate.update(SQL_INSERT_USER_ROLE, user.getUserID(), role.getRoleId());
            }
        }

    }

    @Override
    public void deleteUser(int userId) {
        jdbcTemplate.update(SQL_DELETE_USER_ROLE, userId);
        jdbcTemplate.update(SQL_DELETE_USER, userId);

    }

    @Override
    public void updateUser(User user) {
        final String SQL_UPDATE_USER = "update UserTable set UserName = ?, UserPassword = ?, enabled = ?, PhoneNumber = ?, Email = ?  where UserId = ?";

        Set<Role> roles = user.getRoles();

        jdbcTemplate.update(SQL_UPDATE_USER, user.getUserName(), user.getUserPassword(), user.isEnabled(), user.getPhoneNumber(), user.getEmail(), user.getUserID());
        jdbcTemplate.update(SQL_DELETE_USER_ROLE, user.getUserID());

        if (roles != null) {
            for (Role role : roles) {
                jdbcTemplate.update(SQL_INSERT_USER_ROLE, user.getUserID(), role.getRoleId());
            }
        }
    }

    @Override
    public Set<Role> getRolesForUser(int userId) throws DataAccessException {
        final String SQL_SELECT_ROLES_FOR_USER
                = "SELECT * from roletable where RoleID IN (SELECT RoleID FROM UserRole WHERE UserID = ?)";
        Set<Role> roles = new HashSet(jdbcTemplate.query(SQL_SELECT_ROLES_FOR_USER, new RoleMapper(), userId));
        return roles;

    }

    @Override
    public User getUser(int userId) {
        try {
            User user = jdbcTemplate.queryForObject(SQL_SELECT_USER, new UserMapper(), userId);
            user.setRoles(getRolesForUser(user.getUserID()));
            return user;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = jdbcTemplate.query(SQL_SELECT_ALLUSERS, new UserMapper());
        for (User currentUser : users) {
            currentUser.setRoles(getRolesForUser(currentUser.getUserID()));
        }
        return users;
    }

    @Override
    public User getUserByUsername(String userName) {
        try {
            final String SELECT_USER_BY_USERNAME = "select * from usertable where userName = ?";
            User user = jdbcTemplate.queryForObject(SELECT_USER_BY_USERNAME, new UserMapper(), userName);
            user.setRoles(getRolesForUser(user.getUserID()));
            return user;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    private static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException, DataAccessException {
            int userId = 0;

            User users = new User();

            users.setUserName(rs.getString("UserName"));
            users.setUserPassword(rs.getString("UserPassword"));
            users.setEnabled(rs.getBoolean("Enabled"));
            users.setPhoneNumber(rs.getString("PhoneNumber"));
            users.setEmail(rs.getString("Email"));
            users.setUserID(rs.getInt("UserID"));

            return users;
        }
    }

    private static final class RoleMapper implements RowMapper<Role> {

        @Override
        public Role mapRow(ResultSet rs, int i) throws SQLException, DataAccessException {
            int roleId = 0;

            Role r = new Role();
            r.setRoleName(rs.getString("Role"));
            r.setRoleID(rs.getInt("RoleID"));

            return r;

        }
    }

    @Override
    public void reset() {
        //jdbcTemplate.update(SQL_DELETE_ALL_USER);
    }

}
