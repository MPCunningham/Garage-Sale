/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO USER
 */
public class GarageSale {
    private int GarageSaleId;
    private String address;
    private String  city;
    private String  zipCode;
    private String  state;

    private List<User> userList = new ArrayList<>();

    public int getGarageSaleId() {
        return GarageSaleId;
    }

    public void setGarageSaleId(int garageSaleId) {
        this.GarageSaleId = garageSaleId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}