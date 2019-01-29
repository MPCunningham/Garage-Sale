/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.service;

import com.sg.garagesale.model.User;
import java.util.List;

/**
 *
 * @author LENOVO USER
 */
public interface UserService {
   public void addUser(User user);
    
    public void deleteUser(int userId);
    
    public void updateUser(User user);
    
    public User getUser(int userId);
    
    public List<User> getAllUsers();
    
}
