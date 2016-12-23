/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

import com.warehouse.cookie.SessionManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

/**
 *
 * @author pawel_000
 */
public class CheckOrderNumber extends AbstractPickingAction implements ServletResponseAware, ServletRequestAware{
    protected HttpServletResponse servletResponse;
    protected HttpServletRequest servletRequest;
    
    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        this.servletResponse = hsr;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.servletRequest = hsr;
    }

    @Override
    public void validate() {
        if(String.valueOf(order.getId()) == null) {
            this.addActionError("It's not a number!");
        }
    }

    @Override
    public String execute() {
        if(orderDao.checkOrderById(order.getId())){
            servletResponse.addCookie(SessionManager.createCookie("orderId", String.valueOf(order.getId())));
            
            return SUCCESS;
        }else{
            this.addActionError("I can't find this id");
            return INPUT;
        }
    }
    
}
