/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.dao;

import com.sg.garagesale.model.Role;
import com.sg.garagesale.model.User;
import java.util.List;
import java.util.Set;

/**
 *
 * @author sabaaslam
 */
public interface UserDao {
    
    public void addUser(User user);
    
    public void deleteUser(int userId);
    
    public void updateUser(User user);
    
    public Set<Role> getRolesForUser(int userId);
    
    public User getUser(int userId);
    
    public List<User> getAllUsers();
    
    public User getUserByUsername(String userName);
    
    public void reset();
         
}
