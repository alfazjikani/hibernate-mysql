package com.ihusain.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ihusain.HibernateUtil;
import com.ihusain.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void saveEmployee(Employee emp) {
		Transaction tx = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.save(emp);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

}
