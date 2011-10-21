package com.web.action;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.SessionFactory;

import com.dcs.hibernate.HibernateHome;
import com.web.access.UserHome;
import com.web.bean.User;
import com.web.form.UserDetailForm;

public class UserDetailAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub	
		String cmd =request.getParameter("cmd")==null?"":request.getParameter("cmd");
		//UserDetailForm usrForm = (UserDetailForm)form;
		if(cmd.equals("list")){
			return this.doFindById(mapping, form, request, response);
		}else if(cmd.equals("edit")) {
			return this.doEdit(mapping, form, request, response);
		}else{
			return this.doEdit(mapping, form, request, response);
		}
	}
	 
	//Save or Edit
	public ActionForward doEdit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub	
		HttpSession session = request.getSession();
		UserDetailForm usrForm = (UserDetailForm)form;
		UserHome usrHome = new UserHome();
		SessionFactory ssf = HibernateHome.getSessionFactory();
		try{
			
			User usr = new User();
			usr.setUserId(usrForm.getUserId());
			usr.setUsername(usrForm.getUsername());
			usr.setFirstname(usrForm.getFirstname());
			usr.setLastname(usrForm.getLastname());
			usr.setAddress(usrForm.getAddress());
			usr.setEmail(usrForm.getEmail());
			usr.setSex(usrForm.getSex());
			
			ssf.getCurrentSession().beginTransaction();
			//insert to table
			//usrHome.persist(usr);
			usrHome.saveOrUpdate(usr);
			ssf.getCurrentSession().getTransaction().commit();
			usrForm.setCmd("list");
			
		}catch(Exception e){
			ssf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			ssf.getCurrentSession().close();
		}
		
		return mapping.findForward("success");
	}
	//Find by id
	public ActionForward doFindById(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub	
		// session = request.getSession();
		UserDetailForm usrForm = (UserDetailForm)form;
		UserHome usrHome = new UserHome();
		SessionFactory ssf = HibernateHome.getSessionFactory();
		try{
			ssf.getCurrentSession().beginTransaction();
			usrForm.setUserId(Integer.parseInt(request.getParameter("userId")));
			User usr = usrHome.findById(usrForm.getUserId());
			
			//usrForm.setUserId(usrForm.getUserId());
			usrForm.setUsername(usr.getUsername());
			usrForm.setFirstname(usr.getFirstname());
			usrForm.setLastname(usr.getLastname());
			usrForm.setAddress(usr.getAddress());
			usrForm.setEmail(usr.getEmail());
			usrForm.setSex(usr.getSex());
			usrForm.setMsg("");
			usrForm.setCmd("EDIT");

		}catch(Exception e){
			ssf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			ssf.getCurrentSession().close();
		}
		return mapping.findForward("edit");
	}
}
