package com.web.action;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.SessionFactory;
import com.dcs.hibernate.HibernateHome;
import com.dcs.strut.exten.Action;
import com.dcs.util.DCSCompare;
import com.web.access.CourseHome;
import com.web.bean.Course;
import com.web.form.CourseForm;
import com.web.form.CourseIListForm;


public class CourseListAction extends Action {

	public boolean checkAuthorize() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkUserLogon() {
		// TODO Auto-generated method stub
		return false;
	}

	public ActionForward doAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//edit
		CourseIListForm  cForm = (CourseIListForm)form;
		if("edit".equals(cForm.getCmd())){
			System.out.println("------------->>DDDDDD");
			return this.doGET(mapping, form, request, response);
		}else{
			System.out.println("------------->>");
			return this.doList(mapping, form, request, response);
		}
	}

	public String getProgramID() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	Find by id
	public ActionForward doGET(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub	
		// session = request.getSession();
		//CourseIListForm listForm = (CourseIListForm)form;
		CourseForm cForm = new CourseForm();
		CourseHome cHome = new CourseHome();
		SessionFactory ssf = HibernateHome.getSessionFactory();
		try{
			ssf.getCurrentSession().beginTransaction();
			
			cForm.setCourseCode(request.getParameter("id"));
			System.out.println("==============>> "+cForm.getCourseCode());
			Course cObj = cHome.findById(cForm.getCourseCode());
			
			cForm.setCourseCode(cObj.getCourseCode());
			cForm.setCourseName(cObj.getCourseName()) ;
			cForm.setOverView(cObj.getOverView()) ;
			cForm.setCourseLevel(cObj.getCourseLevel());
			cForm.setDuration(cObj.getDuration());
			cForm.setTarget(cObj.getTarget());
			cForm.setLocation(cObj.getLocation());
			cForm.setClanguage(cObj.getClanguage());
			cForm.setFee(cObj.getFee());
			cForm.setPayment(cObj.getPayment());
			cForm.setRemark(cObj.getRemark());
			cForm.setDdate("");
			
			System.out.println("==============>> xxxxxxxx");
			
			//JSON krub.
			JsonConfig jsonconf = new JsonConfig();
			String [] excludes = {"course"};//exludes in object properties
			jsonconf.setExcludes(excludes);
			
			//setform
			cForm.setItemData(JSONArray.fromObject(cObj.getCoursIns(),jsonconf).toString());
			request.setAttribute("CourseForm", cForm);
			System.out.println("-------->>Name"+cObj.getCourseName());
			
			System.out.println("==============>> xxxxxxxx");

		}catch(Exception e){
			ssf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			ssf.getCurrentSession().close();
		}
		return mapping.findForward("edit");
	}
	
	
//	List all krub.
	public ActionForward doList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reqsponse) throws Exception {
		// TODO Auto-generated method stub
		CourseHome objHome = new CourseHome();
		SessionFactory ssf = HibernateHome.getSessionFactory();
		
		CourseIListForm  cForm = (CourseIListForm)form;
		//CourseForm cForm = (CourseForm)form;
		try{
			ssf.getCurrentSession().beginTransaction();
			
			List<Course> courseList =  objHome.findAll();
			System.out.println("-------findAll krub.");
			//Sorting krub
			//usrForm.setSortColumn("userId");
			
			System.out.println("------1>"+cForm.getSortColumn());
			System.out.println("------2>"+cForm.isSortAscending());
		//	Collections.sort(courseList,new DCSCompare(cForm.getSortColumn(),cForm.isSortAscending()));
			
			request.setAttribute("courseList", courseList);	
			return mapping.findForward("list");
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			ssf.getCurrentSession().close();
		}
	}

	

	
	
}
