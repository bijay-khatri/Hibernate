package com.bijay;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public abstract class HibernateTemplate {
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	protected Session session = null;
	protected Transaction tx = null;
	public abstract void query(Session session, Transaction tx);

	public void start(){
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			query(session,tx);
			tx.commit();
		}
		catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
		}
	}
}
