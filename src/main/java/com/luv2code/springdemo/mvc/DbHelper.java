package com.luv2code.springdemo.mvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DbHelper {
    private SessionFactory con=null;

    public DbHelper(){

    }

    private SessionFactory getConnection() {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserBean.class).buildSessionFactory();
        return sessionFactory;
    }

    public void InsertData(String username, String email, String password, String date,String path) throws Exception {
        try {
            con = getConnection();
            Session session = con.getCurrentSession();
            System.out.println("creating current session...");
            UserBean user = new UserBean(username, email, HashIt.hashThePassword(password), date, path);
            session.beginTransaction();
            System.out.println("saving the data...");
            session.save(user);
            session.getTransaction().commit();
        }finally {
            con.close();
        }
    }

    public boolean validateUser(String username,String password) throws Exception{

            try{
                con = getConnection();
                Session session = con.getCurrentSession();
                session.beginTransaction();
                System.out.println("get user obj");
                String query = "from UserBean u where u.username = '"+username+"' and u.password = '"+HashIt.hashThePassword(password) +"'";
                Query query1 = session.createQuery(query);
                List<UserBean> list = query1.list();
                System.out.println(list);
                if(list.isEmpty()){
                    return false;
                }
                else
                    {
                    return true;
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                con.close();
            }
            return true;
    }

    public UserBean getUserDetail(String username,String password) throws Exception{
        UserBean userobj = null;
        try{
            con = getConnection();
            Session session = con.getCurrentSession();
            session.beginTransaction();
            System.out.println("get user obj");
            String query = "from UserBean u where u.username = '"+username+"' and u.password = '"+HashIt.hashThePassword(password) +"'";
            Query query1 = session.createQuery(query);
            List<UserBean> list = query1.list();
            for (UserBean user1: list) {
                userobj = new UserBean(user1.getUsername(),user1.getEmail(),user1.getPassword(),user1.getDob(),user1.getImagepath());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            con.close();
        }
        return userobj;
    }


}
