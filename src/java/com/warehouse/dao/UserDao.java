/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao;

import com.warehouse.entity.User;
import com.warehouse.utility.HibernateUtility;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pawel_000
 */
class UserDao {
    public boolean find(String name, String password) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        //session.beginTransaction();
        String sql = " from User u where u.login=:name and u.password=:pass";
        Query query = session.createQuery(sql);
        query.setParameter("name", name);
        query.setParameter("pass", password);
        List<User> list = query.list();
        
        if (list.size() > 0) {
            session.close();
            return true;
        }
        
        session.close();
        return false;
    }
}
