package com.bijay;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Bijay on 6/24/2016.
 */
public class ReadHelper extends HibernateTemplate {
    @Override
    public void query(Session session, Transaction tx) {
        List<Department> departments = session.createQuery("select d from com.bijay.Department d").list();
        departments.forEach(System.out::println);


    }

}
