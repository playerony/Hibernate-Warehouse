/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.impl;

import com.warehouse.dao.user.UserDao;
import com.warehouse.entity.User;
import com.warehouse.service.UserService;
import org.hibernate.SessionFactory;

/**
 *
 * @author pawel_000
 */
public class UserDaoImpl implements UserDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean find(String login, String password) {
        for(User u : UserService.list(sessionFactory)){
            if(u.getLogin().equals(login) && u.getPassword().equals(password)){
                return true;
            }
        }
        
        return false;
    }

    @Override
    public boolean findUserByLogin(String login) {
        for(User u : UserService.list(sessionFactory)){
            if(u.getLogin().equals(login))
                return true;
        }
        
        return false;
    }

    @Override
    public boolean addWorker(User user) {
        try{
            UserService.insert(user, sessionFactory);
        }catch(Exception e){
            return false;
        }
        
        return true;
    }

    @Override
    public boolean deleteWorker(String firstname, String lastname) {
        for(User u : UserService.list(sessionFactory)){
            if(u.getFirstname().equals(firstname) && u.getLastname().equals(lastname)){
                UserService.delete(u, sessionFactory);
                return true;
            }
        }
        
        return false;
    }

    @Override
    public String getUserRank(String login, String password) {
        for(User u : UserService.list(sessionFactory)){
            if(u.getLogin().equals(login) && u.getPassword().equals(password)){
                return u.getRank();
            }
        }
        
        return "error";
    }

    @Override
    public String getUserID(String login, String password) {
        for(User u : UserService.list(sessionFactory)){
            if(u.getLogin().equals(login) && u.getPassword().equals(password)){
                return String.valueOf(u.getId());
            }
        }
        
        return "error";
    }
}
