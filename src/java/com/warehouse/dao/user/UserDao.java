/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.user;

import com.warehouse.entity.User;

/**
 *
 * @author pawel_000
 */
public interface UserDao {
    public boolean find(String login, String password);
    
    public boolean findUserByLogin(String login);
    
    public boolean addWorker(User user);
    
    public boolean deleteWorker(String firstname, String lastname);
    
    public String getUserRank(String login, String password);
    
    public String getUserID(String login, String password);
}
