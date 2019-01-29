/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.dao;

import com.sg.garagesale.model.Role;
import java.util.List;

/**
 *
 * @author macam
 */
public interface RoleDao {
    
    Role getRoleById(int RoleId);
    
    Role getRoleByName(String roleName);
    
    List<Role> getAllRoles();
    
    void deleteRole(int RoleId);
    
    void updateRole(Role role);
    
    Role createRole(Role role);
    
}
