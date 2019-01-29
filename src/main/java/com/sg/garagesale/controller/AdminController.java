/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.controller;

import com.sg.garagesale.dao.UserDao;
import com.sg.garagesale.model.User;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author LENOVO USER
 */
@Controller
public class AdminController {

    UserDao uDao;

    @Inject
    public AdminController(UserDao uDao) {
        this.uDao = uDao;
    }

    @RequestMapping(value = "/moderationpage", method = RequestMethod.GET)
    public String displayModerationPage(Model model) {

        List<User> userList = uDao.getAllUsers();

        model.addAttribute("userList", userList);

        return "moderationpage";
    }

    @RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request) {
        String userIdParameter = request.getParameter("userID");
        int userId = Integer.parseInt(userIdParameter);

        uDao.deleteUser(userId);

        return "redirect: moderationpage";
    }

    @RequestMapping(value = "/edituser", method = RequestMethod.GET)
    public String editUser(HttpServletRequest request, Model model) {
        String userIdParameter = request.getParameter("userID");
        int userId = Integer.parseInt(userIdParameter);
        User user = uDao.getUser(userId);
        model.addAttribute("user", user);
        return "edituser";
    }
}
