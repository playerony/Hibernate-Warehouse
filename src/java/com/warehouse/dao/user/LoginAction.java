/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.user;

import com.warehouse.cookie.SessionManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

/**
 *
 * @author pawel_000
 */
public class LoginAction extends AbstractUserAction implements ServletResponseAware, ServletRequestAware{
    protected HttpServletResponse servletResponse;
    protected HttpServletRequest servletRequest;
    
    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void validate() {
        if (user.getLogin().length() == (0)) {
            this.addFieldError("user.login", "Name is required");
        }
        
        if (user.getPassword().length() == (0)) {
            this.addFieldError("user.password", "Password is required");
        }
    }
 
    @Override
    public String execute() {
        if (dao.find(user.getLogin(), user.getPassword())) {
            String rank = dao.getUserRank(user.getLogin(), user.getPassword());
            
            servletResponse.addCookie(SessionManager.createCookie("login", user.getLogin()));
            servletResponse.addCookie(SessionManager.createCookie("rank", rank));
          
            return rank;
        } else {
            this.addActionError("Invalid username and password");
        }
        return INPUT;
    }
}
