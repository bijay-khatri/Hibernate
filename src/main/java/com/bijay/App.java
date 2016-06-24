package com.bijay;

/**
 * Created by Bijay on 6/23/2016.
 */
public class App {
    private static HibernateTemplate myTemplate;
    public static void main(String[] args) {
        //First Seed the DB
        myTemplate = new SeedHelper();
        myTemplate.start();

        //Now Read the DB
        myTemplate = new ReadHelper();
        myTemplate.start();
    }
}
