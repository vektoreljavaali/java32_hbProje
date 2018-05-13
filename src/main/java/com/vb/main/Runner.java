/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vb.main;

import com.vb.dao.tblmusteriDAO;
import com.vb.dao.tblpersonelDAO;
import com.vb.models.tblmusteri;
import com.vb.models.tblpersonel;

/**
 *
 * @author vektorel
 */
public class Runner {
    
    public static void main(String[] args) {
        
        tblmusteriDAO db = new tblmusteriDAO();
        
        tblmusteri mst;
        mst = new tblmusteri();
       
        mst.setSoyad("Kar");
        mst.setAdres("Ankara");
        mst.setTelefon("0 555 666 66 55");
        if(db.kaydet(mst))
            System.out.println("Kayıt Yapıldı");
            else
            System.err.println("Kayıt Yapılamadı");
                
        
        mst = new tblmusteri();
        mst.setAd("Ali ");
        mst.setSoyad("turan");
        mst.setAdres("İstanbul");
        mst.setTelefon("0 444 666 66 55");
        if(db.kaydet(mst))
            System.out.println("Kayıt Yapıldı");
            else
            System.err.println("Kayıt Yapılamadı");
        
        mst = new tblmusteri();
        mst.setAd("Sevim ");
        mst.setSoyad("Meral");
        mst.setAdres("Bursa");
        mst.setTelefon("0 222 666 66 55");
         if(db.kaydet(mst))
            System.out.println("Kayıt Yapıldı");
            else
            System.err.println("Kayıt Yapılamadı");
//        
//        tblpersonelDAO dbp = new tblpersonelDAO();
//        
//        tblpersonel pers = new tblpersonel();
//        pers.setAd("Personel -1");
//        
//        dbp.kaydet(pers);


//         tblmusteriDAO db = new tblmusteriDAO();
//         
//         db.listele(new tblmusteri()).forEach((item) -> {
//             System.out.println("Müşteri Adı......:"+item.getAd());
//        });


//           tblmusteriDAO db = new tblmusteriDAO();
//           if(db.bul(2, new tblmusteri())==null)
//               System.out.println("Hiçbir Kayıt Bulunamadı");
//           else
//               System.out.println("Bulunan Kayıt...:  "+db.bul(2, new tblmusteri()).getAd());

//
//            tblmusteriDAO db = new tblmusteriDAO();
//            
//            for (tblmusteri item : db.ara("ad", "h", new tblmusteri())) {
//                System.out.println("Bulunan KAyıt....: "+item.getAd());
//        }

        
     
          

            
        
    }
}
