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
import com.web.form.UserListForm;

public class UserListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reqsponse) throws Exception {
		// TODO Auto-generated method stub
		
		UserListForm usrForm = (UserListForm)form;
		HttpSession session = request.getSession();
		
		List<User> userList = (ArrayList<User>)session.getAttribute("userList");
		String userId [] = usrForm.getUserId();
		//if(userList!=null && userList.size()>0){
		//(int i = 0;i<userList.)
		//}
		
		if(userId!=null){
			for(int i=0;i<userId.length;i++){
				for(int j=0;i<userList.size();i++){
					if(userId[i].equals(userList.get(j).getUsername())){
						userList.remove(j);
					}
				}
			}
		}
		
		return mapping.findForward("success");
	}
	
	

}
