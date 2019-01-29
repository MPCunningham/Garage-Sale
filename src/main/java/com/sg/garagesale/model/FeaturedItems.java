/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.model;

/**
 *
 * @author LENOVO USER
 */
public class FeaturedItems {
    private int itemId;
    private String itemName;
    private String itemDescription;
    private String itemCategory;
    private int garageSaleId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public Integer getGarageSaleId() {
        return garageSaleId;
    }

    public void setGarageSaleId(int garageSaleId) {
        this.garageSaleId = garageSaleId;
    }
    
}
