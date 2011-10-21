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
import com.web.form.UserListForm;

public class UserListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reqsponse) throws Exception {
		// TODO Auto-generated method stub
		//String cmd = request.getParameter("cmd")==null?"":request.getParameter("cmd");
		UserListForm usrListForm = (UserListForm)form;

		if(usrListForm.getCmd()==null)
			 usrListForm.setCmd("");
		
		System.out.println("------->>Del :"+usrListForm.getCmd());
		
		if(usrListForm.getCmd().equals("del")){
			return this.doDelete(mapping, form, request, reqsponse);
		}else{
			return this.doList(mapping, form, request, reqsponse);
		}
	}
	
	//List all
	public ActionForward doDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reqsponse) throws Exception {
		// TODO Auto-generated method stub
		UserHome usrHome = new UserHome();
		SessionFactory ssf = HibernateHome.getSessionFactory();
		try{ 
			System.out.println("-----doDelete");
			UserListForm usrListForm = (UserListForm)form;
			ssf.getCurrentSession().beginTransaction();
			int []userId = usrListForm.getUserId();
			
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
	
	//List all
	public ActionForward doList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reqsponse) throws Exception {
		// TODO Auto-generated method stub
		UserHome usrHome = new UserHome();
		SessionFactory ssf = HibernateHome.getSessionFactory();
		try{
			ssf.getCurrentSession().beginTransaction();
			List<User> userList =  usrHome.findAll();
			System.out.println("-------xxxxx");
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
	
	
}


/*UserListForm usrForm = (UserListForm)form;
HttpSession session = request.getSession();

List<User> userList = (ArrayList<User>)session.getAttribute("userList");
String userId [] = usrForm.getUserId();
//if(userList!=null && userList.size()>0){
//(int i = 0;i<userList.)
//}

System.out.println("--------->>xxx");
System.out.println("--------->>xxx"+userId.length);
System.out.println("--------->>xxx"+userList);
if(userId!=null){
	for(int i=0;i<userId.length;i++){
		for(int j=0;i<userList.size();i++){
			if(userId[i].equals(userList.get(j).getUsername())){
				userList.remove(j);
			}
		}
	}
}*/