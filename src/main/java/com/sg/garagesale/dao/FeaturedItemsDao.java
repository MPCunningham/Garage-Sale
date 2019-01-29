/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.dao;


import com.sg.garagesale.model.FeaturedItems;
import java.util.List;

/**
 *
 * @author LENOVO USER
 */
public interface FeaturedItemsDao {
    public void addItem(FeaturedItems items);
    
    public void deleteItem(int itemId);
    
    public void updateItem(FeaturedItems item);
    
    public FeaturedItems getItem(int itemId);
    
    public List<FeaturedItems> getAllItems();
    public List<FeaturedItems> getItemsByGarageSale(int garageId);
    public void reset();
    
}
