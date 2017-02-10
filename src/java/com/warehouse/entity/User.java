/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author pawel_000
 */

@Entity
@Table(name="worker")
public class User implements Serializable{
    
    @Id
    @Column(name="worker_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Column(name="worker_firstname")
    private String firstname;
    @Column(name="worker_lastname")
    private String lastname;
    @Column(name="work_place")
    private String place;
    @Column(name="worker_login")
    private String login;
    @Column(name="worker_password")
    private String password;
    @Column(name="worker_rank")
    private String rank;
    
    public User(){
        
    }
    
    public User(int id, String login, String password, String rank){
        this.id = id;
        this.login = login;
        this.password = password;
        this.rank = rank;
    }
    
    public User(int id, String firstname, String lastname, String login, String password, String place, String rank){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        this.place = place;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
    
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
