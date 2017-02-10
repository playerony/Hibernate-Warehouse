/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

import com.opensymphony.xwork2.ActionSupport;
import com.warehouse.entity.Client;
import com.warehouse.entity.Order;
import com.warehouse.entity.PalleteInfo;
import com.warehouse.entity.PalletsInMagazine;
import com.warehouse.impl.MagazineDaoImpl;
import com.warehouse.impl.OrderDaoImpl;
import com.warehouse.impl.PickingDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author pawel_000
 */
public abstract class AbstractPickingAction extends ActionSupport{
    protected Order order;
    protected Client client;
    protected PalleteInfo palleteInfo;
    protected PalletsInMagazine palletsInMagazine;
    protected OrderDao orderDao;
    protected MagazineDao magazineDao;
    protected PickingDao pickingDao;
    
    public AbstractPickingAction(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        orderDao = context.getBean(OrderDaoImpl.class);
        magazineDao = context.getBean(MagazineDaoImpl.class);
        pickingDao = context.getBean(PickingDaoImpl.class);
    }
    
    @Override
     public abstract void validate();
     @Override
     public abstract String execute();
     
     public Client getClient() {
        return client;
    }
 
    public void setClient(Client client) {
        this.client = client;
    } 
    
    public Order getOrder() {
        return order;
    }
 
    public void setOrder(Order order) {
        this.order = order;
    } 
    
    public PalleteInfo getPalleteInfo() {
        return palleteInfo;
    }

    public void setPalleteInfo(PalleteInfo palleteInfo) {
        this.palleteInfo = palleteInfo;
    }

    public PalletsInMagazine getPalletsInMagazine() {
        return palletsInMagazine;
    }

    public void setPalletsInMagazine(PalletsInMagazine palletsInMagazine) {
        this.palletsInMagazine = palletsInMagazine;
    }
}
