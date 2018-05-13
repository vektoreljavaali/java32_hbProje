/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vb.util;

import com.vb.models.tbllog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vektorel
 */
public class logislemleri {
    Session ss;
    public void kaydet(tbllog t){
    
        ss = NewHibernateUtil.getSessionFactory().openSession();
        
        try{
        
            if(ss.isConnected()){
              dbkaydet(t);
            }
            else{
              dosyayakaydet(t);
            }
            
        }catch(Exception ex){
          dosyayakaydet(t);
        }
        
    }// kaydet method sonu.
    
    private void dbkaydet(tbllog t){
        Transaction tt = ss.beginTransaction();
        ss.save(t);
        tt.commit();
        ss.close();
    }
    
    private void dosyayakaydet(tbllog t){
    
         try{
        File fl = new File("src//main/java//com//vb//logfile//log.txt");
            BufferedWriter bf = new BufferedWriter(new FileWriter(fl,true));
            bf.append("Tarih..: "+t.getTarih()+":"+
                    "Sınıf....: "+t.getSinif()+":"+
                    "Method...: "+t.getMethod()+":"+
                    "Hata.....: "+t.getHataicerigi()
                    );
            bf.newLine();
            bf.close();
          
        }
        catch(Exception ex){
            System.err.println("Hata...:"+ex.toString());
       
        }
    
    }

}// class sonu

