/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.dao;

import com.sg.garagesale.model.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macam
 */
@Repository
public class RoleDaoDB implements RoleDao {
    
    JdbcTemplate jdbc;
    
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Role getRoleById(int RoleId) {
        try{
            final String SELECT_ROLE_BY_ID = "Select * from RoleTable where RoleID = ?";
            return jdbc.queryForObject(SELECT_ROLE_BY_ID, new RoleMapper(), RoleId);
        }catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    public Role getRoleByName(String roleName) {
         try{
             final String SELECT_ROLE_BY_ROLE = "Select * from RoleTable where Role = ?";
             return jdbc.queryForObject(SELECT_ROLE_BY_ROLE, new RoleMapper(), roleName);
         }catch (DataAccessException ex){
             return null;
         }
    }

    @Override
    public List<Role> getAllRoles() {
        final String SELECT_ALL_ROLES = "Select * from RoleTable";
        return jdbc.query(SELECT_ALL_ROLES, new RoleMapper());
    }

    @Override
    public void deleteRole(int RoleId) {
        final String DELETE_USER_ROLE = "delete from userrole where RoleID = ?";
        final String DELETE_ROLE = "delete from RoleTable where RoleID = ?";
        jdbc.update(DELETE_USER_ROLE, RoleId);
        jdbc.update(DELETE_ROLE, RoleId);
    }

    @Override
    public void updateRole(Role role) {
        final String UPDATE_ROLE = "update RoleTable set Role = ? where RoleID = ?";
        jdbc.update(UPDATE_ROLE, role.getRoleName(), role.getRoleId());
    }

    @Override
    public Role createRole(Role role) {
        final String INSERT_ROLE = "insert into RoleTable(role) values(?)";
        jdbc.update(INSERT_ROLE, role.getRoleName());
        int newId = jdbc.queryForObject("select LAST_INSERT_ID()", Integer.class);
        role.setRoleID(newId);
        return role;
    }
        
    private static final class RoleMapper implements RowMapper<Role> {

        @Override
        public Role mapRow(ResultSet rs, int i) throws SQLException {
            Role role = new Role();
            role.setRoleID(rs.getInt("RoleID"));
            role.setRoleName(rs.getString("Role"));
            return role;
        }
    }
}
