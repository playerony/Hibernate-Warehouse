/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pawel_000
 */
public class SessionManager {
    private static final int SESSION_TIME = 15;
    private static HttpSession session;
    private static Cookie cookie;
    
    public static Cookie createCookie(String location, String name){
        cookie = new Cookie(location, name);
        cookie.setMaxAge(SESSION_TIME * 60);
        
        return cookie;
    }
    
    public static void createSession(String location, String login, HttpServletRequest request){
        session = request.getSession();
        session.setAttribute(location, login);
		
        session.setMaxInactiveInterval(SESSION_TIME * 60);
    }
}
