package com.bijay;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Bijay on 6/24/2016.
 */
public class SeedHelper extends HibernateTemplate {
    @Override
    public void query(Session session, Transaction tx) {

      Employee employee1 = new Employee("Bijay Khatri", 1L);
      Employee employee2 = new Employee("Sandip Tripathi ", 2L);
      Employee employee3 = new Employee("Rishikesh Mandal ",3L);
      Employee employee4 = new Employee("Nischal Niraula ", 4L);

      session.save(employee1);
      session.save(employee2);
      session.save(employee3);
      session.save(employee4);

      Department department1 = new Department("Computer");
      Department department2 = new Department("Car");

     department1.addEmployee(employee1);
     department1.addEmployee(employee2);

     department2.addEmployee(employee3);
     department2.addEmployee(employee4);

     session.persist(department1);
     session.persist(department2);



    }
}
