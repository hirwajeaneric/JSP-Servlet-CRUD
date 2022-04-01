package com.jsp.servlet.crud.controller;

import com.jsp.servlet.crud.model.User;
import com.jsp.servlet.crud.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {
    Transaction tx;
    Session ss;
    
    public void saveUser(User user){
        try {
            ss = HibernateUtil.getSessionFactory().openSession();
            tx = ss.beginTransaction();
            ss.save(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            ss.close();
        }
    }
    
    /*Retrieving userList*/
    public List<User> getAllUser(){
        ss = HibernateUtil.getSessionFactory().openSession();
        tx = ss.beginTransaction();
        List<User> userList = ss.createQuery("FROM User").list();   
        tx.commit();
        ss.close();
        return userList;        
    }
    
    public void updateUser(User user){
        try {
            ss = HibernateUtil.getSessionFactory().openSession();
            tx = ss.beginTransaction();
            ss.update(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            ss.close();
        }
    }
    
    public void deleteUser(int id){
        try {
            ss = HibernateUtil.getSessionFactory().openSession();
            tx = ss.beginTransaction();
            User user = (User) ss.get(User.class,id);
            if(user != null) {
                ss.delete(user);
                System.out.println("user is deleted");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            ss.close();
        }
    }
}
