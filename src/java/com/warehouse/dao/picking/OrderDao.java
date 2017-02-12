/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

/**
 *
 * @author pawel_000
 */
public interface OrderDao {
    public boolean checkOrderById(int id);
    
    public boolean updateOrderValue(int id, String phrase);
    
    public boolean deleteOrder(int id);
    
    public String getProducts(int id);
    
    public int getClientID(int id);
}
