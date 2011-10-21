package com.web.access;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.BetweenExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import com.dcs.hibernate.HibernateHome;
import com.web.bean.User;
public class UserHome extends HibernateHome {
	
	public User findById(int userId){
		
		try{
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
			crit.add(Restrictions.eq("userId", userId));
			return (User)crit.uniqueResult();
						
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public List findAll(){
		//SessionFactory ssf = HibernateHome.getSessionFactory();
		try{
			//ssf.getCurrentSession().isDefaultReadOnly();
			System.out.println("--->FindAllx");
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
			//crit.add(Restrictions.gt("userId", 300));
			crit.add(Restrictions.between("userId", 300, 400));
			
			crit.addOrder(Order.asc("userId"));
			System.out.println("--->FindAll");
			return crit.list();
						
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public void delete(int userId){
		try{
			System.out.println("--->Delete");
			//Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
			Query qry = sessionFactory.getCurrentSession().createSQLQuery("delete from User where userId=:uid");
			qry.setInteger("uid", userId);
			qry.executeUpdate();
			
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public void deleteTelById(int userId){
		try{
			System.out.println("--->Delete");
			//Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
			Query qry = sessionFactory.getCurrentSession().createSQLQuery("delete from Telephone where userId=:uid");
			qry.setInteger("uid", userId);
			qry.executeUpdate();
			
		}catch(RuntimeException e){
			throw e;
		}
	}
	

}
