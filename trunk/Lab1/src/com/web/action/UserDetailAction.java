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

import com.web.bean.User;
import com.web.form.UserDetailForm;

public class UserDetailAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub	
		HttpSession session = request.getSession();
		List<User> userList = (ArrayList<User>)session.getAttribute("userList");
		
		//boolean isValidate = false;
		UserDetailForm usrForm = (UserDetailForm)form;
		//System.out.println("---->Acction  "+usrForm.getUsername());
		if(usrForm.getUsername().equals("")){
			usrForm.setMsg("Please input user name.");
			//isValidate = true;
			return mapping.findForward("error");
		}
		if(usrForm.getFirstname().equals("")){
			usrForm.setMsg("Please input First name.");
			//isValidate = true;
			return mapping.findForward("error");
		}
		if(usrForm.getLastname().equals("")){
			usrForm.setMsg("Please input last name.");
			//isValidate = true;
			return mapping.findForward("error");
		}
		if(usrForm.getEmail().equals("")){
			usrForm.setMsg("Please input Email.");
			//isValidate = true;
			return mapping.findForward("error");
		}
		if(usrForm.getAddress().equals("")){
			usrForm.setMsg("Please input Address.");
			//isValidate = true;
			return mapping.findForward("error");
		}
		if(usrForm.getSex().equals("")){
			usrForm.setMsg("Please input Sex.");
			//isValidate = true;
			return mapping.findForward("error");
		}

			if(userList==null) userList = new ArrayList<User>();
			
			User usr = new User();
				usr.setUsername(usrForm.getUsername());
				usr.setFirstname(usrForm.getFirstname());
				usr.setLastname(usrForm.getLastname());
				usr.setAddress(usrForm.getAddress());
				usr.setEmail(usrForm.getEmail());
				usr.setSex(usrForm.getSex());
				userList.add(usr);		
			session.setAttribute("userList", userList);			
			return mapping.findForward("success");
	}

}
