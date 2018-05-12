/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vb.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author vektorel
 */
@Entity
@Table
public class tblmusteri {
 
    @Id
    @SequenceGenerator(name = "sq_tblmusteri",
            sequenceName = "sq_tblmusteri_id",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator ="sq_tblmusteri" )
    private int id;
    private String ad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
    
    
    
    
}
