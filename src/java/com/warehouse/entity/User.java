/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.entity;

import java.io.Serializable;

/**
 *
 * @author pawel_000
 */
public class User implements Serializable{
    private long id;
    private String login;
    private String password;
    private String rank;
    
    public User(){
        
    }
    
    public User(long id, String login, String password){
        this.id = id;
        this.login = login;
        this.password = password;
    }
    
    public User(long id, String login, String password, String rank){
        this.id = id;
        this.login = login;
        this.password = password;
        this.rank = rank;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
