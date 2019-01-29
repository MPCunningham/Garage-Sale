/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.dao;

import com.sg.garagesale.model.Contact;
import com.sg.garagesale.model.GarageSale;
import java.util.List;

/**
 *
 * @author 4oaks
 */
public interface GarageSaleDao {
    
    public void addGarageSale(GarageSale sale);
    
    public void deleteGarageSale(int saleId);
    
    public void updateGarageSale(GarageSale sale);
    
    public GarageSale getGarageSale(int saleId);
    
    public List<GarageSale> getAllGarageSales();
    
    public void reset();
    
    public List<GarageSale> getGarageSaleByCity(String city);
    public List<GarageSale> getGarageSaleByState(String state);
    public List<GarageSale> getGarageSaleByZip(String zip);
}
