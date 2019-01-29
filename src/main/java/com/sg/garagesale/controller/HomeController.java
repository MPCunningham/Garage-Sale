/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.controller;

import com.sg.garagesale.dao.RoleDao;
import com.sg.garagesale.dao.UserDao;
import com.sg.garagesale.model.Role;
import com.sg.garagesale.model.User;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author sabaaslam
 */
@Controller
public class HomeController {

    UserDao uDao;

    @Inject
    PasswordEncoder encoder;

    @Inject
    RoleDao roles;

    @Inject
    public HomeController(UserDao uDao) {
        this.uDao = uDao;
    }

    @RequestMapping(value = {"/", "/Home"}, method = RequestMethod.GET)
    public String displayHomePage() {
        
        return "home";
    }

    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String displayRegisterPage() {
        return "register";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(HttpServletRequest request) {

        User user = new User();
        user.setUserName(request.getParameter("username"));
        user.setUserPassword(encoder.encode(request.getParameter("password")));
        user.setEnabled(true);
        user.setContactName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setPhoneNumber(request.getParameter("phone"));
        
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roles.getRoleByName("user"));
        user.setRoles(userRoles);

        uDao.addUser(user);

        return "home";

    }
}
