/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.warehouse.dao.user.LoginAction;
import java.util.Map;

/**
 *
 * @author pawel_000
 */
public class GlobalInterceptor implements Interceptor{
    Map<String, Object> session;

    @Override
    public void destroy() {
        
    }

    @Override
    public void init() {
        
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String,Object> session = invocation.getInvocationContext().getSession();
        
        Object action = invocation.getAction();

        if (action instanceof LoginAction) 
            return invocation.invoke();
        
        if(session.isEmpty())
            return "session";
        
        return invocation.invoke();
    }
    
}
