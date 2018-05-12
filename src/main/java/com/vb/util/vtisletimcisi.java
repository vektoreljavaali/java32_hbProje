/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vb.util;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author vektorel
 */
public class vtisletimcisi<T> implements icrud<T>{
    Session ss;
    Transaction tt;
    
    public void ac(){
       ss = NewHibernateUtil.getSessionFactory().openSession();
       tt = ss.beginTransaction();
    }
    
    public void kapat(){
        tt.commit();
        ss.close();
    }
    
    @Override
    public boolean kaydet(T t) {
        ac();
        ss.save(t);
        kapat();
        
        
        return true;
    }

    @Override
    public boolean duzenle(T t) {
        ac();
        ss.update(t);
        kapat();
        
        return true;
    }

    @Override
    public boolean sil(T t) {
        ac();
        //ss.update(t);
        ss.delete(t);
        kapat();
        
        return true;
    }

    @Override
    public List<T> listele(T t) {
      
       List<T> liste;
       ac();
       Criteria cr = ss.createCriteria(t.getClass());
       liste = cr.list();
       kapat();
       return liste;        
        
    }

    @Override
    public T bul(int id, T t) {
       T result=null;
       ac();
       Criteria cr = ss.createCriteria(t.getClass());
       cr.add(Restrictions.eq("id", id));
       if(cr.list().size()>0)
       result = (T) cr.list().get(0);
       kapat();
       return result;               
    }

    @Override
    public List<T> ara(String kolonadi, String aranan, T t) {
       List<T> result;
       ac();
       Criteria cr = ss.createCriteria(t.getClass());
       cr.add(Restrictions.ilike(kolonadi, "%"+aranan+"%"));
       result = cr.list();
       kapat();
       return result;       
    }

    @Override
    public List<T> ara(T t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
