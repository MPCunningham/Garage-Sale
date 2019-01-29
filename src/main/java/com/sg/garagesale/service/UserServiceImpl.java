/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.service;

import com.sg.garagesale.dao.UserDao;
import com.sg.garagesale.model.User;
import java.util.List;

/**
 *
 * @author LENOVO USER
 */
public class UserServiceImpl implements UserService{
    
    UserDao userdao;
    
    public UserServiceImpl(UserDao userdao){
     this.userdao = userdao;   
    }

    @Override
    public void addUser(User user) {
        userdao.addUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        userdao.deleteUser(userId);
    }

    @Override
    public void updateUser(User user) {
        userdao.updateUser(user);
    }

    @Override
    public User getUser(int userId) {
        return userdao.getUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userdao.getAllUsers();
    }
    
    
}
