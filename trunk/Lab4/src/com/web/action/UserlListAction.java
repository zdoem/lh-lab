package com.web.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.SessionFactory;

import com.dcs.hibernate.HibernateHome;
import com.dcs.strut.exten.Action;
import com.dcs.util.DCSCompare;
import com.web.access.UserHome;
import com.web.bean.User;
import com.web.form.UserListForm;
import com.web.form.UserlListForm;

public class UserlListAction extends Action {

	public boolean checkAuthorize() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkUserLogon() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String getProgramID() {
		// TODO Auto-generated method stub
		return null;
	}

	public ActionForward doAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
			UserlListForm usrlListForm  = (UserlListForm)form;
			if("delete".equals(usrlListForm.getCmd())){
				return this.doDelete(mapping, form, request, response);
			}else{
				return this.doList(mapping, form, request, response);
			}
	}
	//List all krub.
	public ActionForward doList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reqsponse) throws Exception {
		// TODO Auto-generated method stub
		UserHome usrHome = new UserHome();
		SessionFactory ssf = HibernateHome.getSessionFactory();
		
		UserlListForm  usrForm = (UserlListForm)form;
		try{
			ssf.getCurrentSession().beginTransaction();
			List<User> userList =  usrHome.findAll();
			System.out.println("-------findAll krub.");
			//Sorting krub
			//usrForm.setSortColumn("userId");
			
			System.out.println("------1>"+usrForm.getSortColumn());
			System.out.println("------2>"+usrForm.isSortAscending());
			Collections.sort(userList,new DCSCompare(usrForm.getSortColumn(),usrForm.isSortAscending()));
			
			request.setAttribute("userList", userList);	
			return mapping.findForward("success");
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			ssf.getCurrentSession().close();
		}
	}
	
	//Delte krub.
	public ActionForward doDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reqsponse) throws Exception {
		// TODO Auto-generated method stub
		UserHome usrHome = new UserHome();
		SessionFactory ssf = HibernateHome.getSessionFactory();
		try{ 
			System.out.println("-----doDelete");
			UserlListForm usrListForm = (UserlListForm)form;
			ssf.getCurrentSession().beginTransaction();
			int []userId = usrListForm.getDelUserId();
			
			for(int i=0;i<userId.length;i++){
				usrHome.delete(userId[i]);
			}
			
			ssf.getCurrentSession().beginTransaction().commit();
			usrListForm.setCmd("list");
			
			return mapping.findForward("del_page");
		}catch(Exception e){
			e.printStackTrace();
			ssf.getCurrentSession().beginTransaction().rollback();
			return null;
		}
		finally{
			ssf.getCurrentSession().close();
		}
	}


}
