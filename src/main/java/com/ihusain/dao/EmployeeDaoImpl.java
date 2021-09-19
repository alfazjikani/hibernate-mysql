package com.ihusain.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ihusain.HibernateUtil;
import com.ihusain.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee findEmployee(Employee emp) {
		Transaction tx = null;
		Employee emp2 = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			
			emp2 = session.load(Employee.class, emp.getId());
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
		return emp2;
	}

	@Override
	public void saveEmployee(Employee emp) {
		Transaction tx = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.persist(emp);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateEmployee(Employee emp) {
		Transaction tx = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			Employee m = (Employee)session.merge(emp);
			session.persist(m);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
	@Override
	public void removeEmployee(Employee emp) {
		Transaction tx = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.remove(emp);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

}
