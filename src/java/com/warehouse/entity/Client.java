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
@Table(name="client")
public class Client implements Serializable {
    
    @Id
    @Column(name="client_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Column(name="client_name")
    private String name;
    @Column(name="client_address")
    private String address;
    @Column(name="client_phone")
    private String phone;
    
    public Client(){
        
    }
    
    public Client(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public Client(int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    public Client(int id, String name, String address, String phone){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
