package com.app.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.app.models.Employee;
import com.app.resources.AddEmployee;

public class DaoImp {
	Logger logger=Logger.getLogger(DaoImp.class);

	public Session getconntion() {
		
		Configuration configure = new Configuration().configure();
		SessionFactory buildSessionFactory = configure.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		
		return openSession;

		
	}
	
	public void register(Employee employee) {
		
		logger.info("Entering into DaoImplimentation......");
	
		Session openSession = new Configuration().configure().buildSessionFactory().openSession();
		openSession.save(employee);
		openSession.beginTransaction().commit();
		
		logger.info("Triigered from DaoImplimentation......");

	}
	public List<Employee> getall() {
		
		Session session = getconntion();
		List<Employee> list = session.createCriteria(Employee.class).list();
		
		return list;
		
	}
	/*public static void main(String[] args) {
		DaoImp daoImp=new DaoImp();
		Session getconntion = daoImp.getconntion();
		List<Employee> list = getconntion.createCriteria(Employee.class).list();
		System.out.println(list);
	}
*/
}
