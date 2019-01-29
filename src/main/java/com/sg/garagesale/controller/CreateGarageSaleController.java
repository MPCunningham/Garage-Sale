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
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author sabaaslam
 */
@Controller
public class CreateGarageSaleController {
    GarageSaleDao dao;
    FeaturedItemsDao dao2;
    
    
    @Inject
    public CreateGarageSaleController(GarageSaleDao dao, FeaturedItemsDao dao2){
        this.dao = dao;
        this.dao2 = dao2;
    }
    
    
    
    
    @RequestMapping(value = "/Garagesale", method = RequestMethod.GET)
    public String displayGarageSales(Model model) {
        List<GarageSale> listOfGarageSales = dao.getAllGarageSales();
        model.addAttribute("listOfGarageSales", listOfGarageSales);
        return "Garagesale";
    }
    
//    @RequestMapping(value = "/Garagesale", method = RequestMethod.GET)
//    public String displayGarageSale(HttpServletRequest request, Model model) {
//        String saleId = request.getParameter("saleId");
//        int id = Integer.parseInt(saleId);
//        GarageSale sale = dao.getGarageSale(id);
//        model.addAttribute("sale", sale);
//        return "garageDetails";
//    }
//    

        @RequestMapping(value = "/CreateSale", method = RequestMethod.GET)
    public String createSalePage(HttpServletRequest request){
        return "CreateSale";
    }
    
    @RequestMapping(value = "/CreateSale", method = RequestMethod.POST)
    public String createSaleResults(HttpServletRequest request){
        GarageSale sale = new GarageSale();
        
        sale.setAddress(request.getParameter("address"));
        sale.setCity(request.getParameter("City"));
        sale.setZipCode(request.getParameter("Zip"));
        sale.setState(request.getParameter("state"));
        dao.addGarageSale(sale);
        
        return "redirect:Garagesale";
    }
    @RequestMapping(value = "/deleteGarageSale", method = RequestMethod.GET)
    public String deleteGarageSale(HttpServletRequest request) {
    String saleIdParameter = request.getParameter("garageSaleId");
    int garageSaleId = Integer.parseInt(saleIdParameter);
    dao.deleteGarageSale(garageSaleId);
    return "redirect:Garagesale";
}
    
    @RequestMapping(value = "/displayEditGarageSale", method = RequestMethod.GET)
    public String displayEditGarageSale(HttpServletRequest request, Model model) {
    String saleIdParameter = request.getParameter("garageSaleId");
    int garageSaleId = Integer.parseInt(saleIdParameter);
    GarageSale sale = dao.getGarageSale(garageSaleId);
    model.addAttribute("sale", sale);
    return "EditGarageSale";
}
    @RequestMapping(value = "/editGarage", method = RequestMethod.POST)
    public String editGarage(@ModelAttribute("sale") GarageSale sale) {

    dao.updateGarageSale(sale);

    return "redirect:Garagesale";
}
    
    @RequestMapping(value="/ViewGarageSale", method=RequestMethod.GET)
    public String ViewGarageSale(HttpServletRequest request, Model model) {
        String garageIdParameter = request.getParameter("GarageSaleId");
        
        int id = Integer.parseInt(garageIdParameter);
        
        List<FeaturedItems> itemList = dao2.getItemsByGarageSale(id);
        
        model.addAttribute("itemList", itemList);
        
        return "ViewItem";
    }
    
}
