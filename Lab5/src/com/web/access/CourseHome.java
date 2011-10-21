package com.web.access;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.dcs.hibernate.HibernateHome;
import com.web.bean.Course;


public class CourseHome extends HibernateHome{
	
	public Course findById(String id){
		
		try{
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(Course.class);
			crit.add(Restrictions.eq("courseCode", id));
			return (Course)crit.uniqueResult();
						
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public List findAll(){
		//SessionFactory ssf = HibernateHome.getSessionFactory();
		try{
			//ssf.getCurrentSession().isDefaultReadOnly();
			System.out.println("--->FindAllx");
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(Course.class);
			//crit.add(Restrictions.gt("userId", 300));
			//crit.add(Restrictions.between("userId", 300, 400));
			
			//crit.addOrder(Order.asc("userId"));
			System.out.println("--->FindAll");
			return crit.list();
						
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public void deleteCourse(String id){
		try{
			System.out.println("--->Delete");
			//Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
			Query qry = sessionFactory.getCurrentSession().createSQLQuery("delete from Course where coursecode=:uid");
			qry.setString("uid", id);
			qry.executeUpdate();
			
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	public void deleteCourseInsById(String courseId){
		try{
			System.out.println("--->Delete");
			//Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
			Query qry = sessionFactory.getCurrentSession().createSQLQuery("delete from CourseInstructor where coursecode=:uid");
			qry.setString("uid", courseId);
			qry.executeUpdate();
			
		}catch(RuntimeException e){
			throw e;
		}
	}
	


}
