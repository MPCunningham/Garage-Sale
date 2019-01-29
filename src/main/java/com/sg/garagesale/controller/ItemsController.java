/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.controller;

import com.sg.garagesale.dao.FeaturedItemsDao;
import com.sg.garagesale.dao.GarageSaleDao;
import com.sg.garagesale.model.FeaturedItems;
import com.sg.garagesale.model.GarageSale;
import java.util.List;
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
public class ItemsController {

    FeaturedItemsDao dao;
    GarageSaleDao dao2;

    public ItemsController(FeaturedItemsDao dao, GarageSaleDao dao2) {
        this.dao = dao;
        this.dao2 = dao2;

    }

    @RequestMapping(value = "/ViewItem", method = RequestMethod.GET)
    public String ViewItems(Model model,HttpServletRequest request) {
          String saleIdParameter = request.getParameter("garageSaleId");
        int garageSaleId = Integer.parseInt(saleIdParameter);
        List<FeaturedItems> listOfItems = dao.getItemsByGarageSale(garageSaleId);
        model.addAttribute("listOfItems", listOfItems);
        return "ViewItem";
    }


    @RequestMapping(value = "/CreateItem", method = RequestMethod.POST)
    public String createItem(HttpServletRequest request, Model model) {
        String saleIdParameter = request.getParameter("garageSaleId");
        int garageSaleId = Integer.parseInt(saleIdParameter);
        GarageSale sale = dao2.getGarageSale(garageSaleId);
        FeaturedItems item = new FeaturedItems(); 
        item.setItemCategory(request.getParameter("Category"));
        item.setItemDescription(request.getParameter("itemDescription"));
        item.setItemName(request.getParameter("itemName"));
        item.setGarageSaleId(garageSaleId);
        dao.addItem(item);
        return "redirect:ViewItem";
    }

    @RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
    public String deleteItem(HttpServletRequest request, Model model) {
        String itemIdParameter = request.getParameter("itemId");
        int itemId = Integer.parseInt(itemIdParameter);
        dao.deleteItem(itemId);
        List<FeaturedItems> listOfItems = dao.getAllItems();
        model.addAttribute("listOfItems", listOfItems);
        return "ViewItem";
    }

}
