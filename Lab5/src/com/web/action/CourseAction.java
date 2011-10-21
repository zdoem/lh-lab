package com.web.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.SessionFactory;
import com.dcs.hibernate.HibernateHome;
import com.dcs.strut.exten.Action;
import com.dcs.util.DCSCompare;
import com.web.access.CourseHome;
import com.web.bean.Course;
import com.web.bean.CourseInstructor;
import com.web.form.CourseForm;
import com.web.form.CourseIListForm;


public class CourseAction extends Action {
	private final Logger log =  Logger.getLogger(CourseAction.class);

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

	//----------->>Execute
	public ActionForward doAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		//CourseIListForm cForm  = (CourseIListForm)form;
/*		String cmd = request.getParameter("cmd")==null?"":request.getParameter("cmd");
		CourseForm cForm = null;
		if(cmd.equals("list")){
			cForm= (CourseForm)form;
		}*/
/*		CourseForm cForm = (CourseForm)form;
		
		if("save".equals(cForm.getCmd())){
			System.out.println("------------->>DDDDDD");
			return this.doADD(mapping, form, request, response);
		}else{
			System.out.println("------------->>");
			return this.doList(mapping, form, request, response);
		}*/
		
		return this.doADD(mapping, form, request, response);
		
	}
	
//	Save or Edit
	public ActionForward doADD(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub	
		log.info("===call doADD===");
		HttpSession session = request.getSession();
		CourseForm cForm = (CourseForm)form;
		CourseHome  cHome = new CourseHome();
		SessionFactory ssf = HibernateHome.getSessionFactory();
		try{
			
			log.info("===call xxxxxxx===");
			Course obj = new Course();
			obj.setCourseCode(cForm.getCourseCode());
			obj.setCourseName(cForm.getCourseName());
			obj.setOverView(cForm.getOverView());
			obj.setCourseLevel(cForm.getCourseLevel());
			obj.setDuration(cForm.getDuration());
			obj.setClanguage(cForm.getClanguage());
			obj.setTarget(cForm.getTarget());
			obj.setLocation(cForm.getLocation());
			obj.setFee(cForm.getFee());
			obj.setPayment(cForm.getPayment());
			obj.setRemark(cForm.getRemark());
			obj.setUpdateDay(new java.util.Date(cForm.getDdate()));

			
			List<CourseInstructor> insList  = new ArrayList<CourseInstructor>();
			log.debug("----->>json1");
			Object[] objItemDetail = {};
			objItemDetail = JSONArray.toCollection(JSONArray.fromObject(cForm.getItemData()),CourseInstructor.class).toArray();
			log.debug("json2 ---->"+cForm.getItemData());
			
			for (int i = 0;i<objItemDetail.length;i++){
				log.debug("#json1-for");
				if(objItemDetail[i]==null){
					System.out.println("---------->>Test xxx");
				}else{					
					CourseInstructor insObj = (CourseInstructor)objItemDetail[i];
					insObj.setCourse(obj);	
					insObj.setSeq(i+1);
					insList.add(insObj);
					log.debug("#json2-end");
				}
			}
			log.debug("json3");
			
			obj.setCoursIns(insList);
			log.info("==11111===");
			
			ssf.getCurrentSession().beginTransaction();
			//insert to table
			//usrHome.persist(usr);
			cHome.deleteCourseInsById(obj.getCourseCode());
			System.out.println("------>Delete success.");
			cHome.saveOrUpdate(obj);
			log.info("==2222222===");
			ssf.getCurrentSession().getTransaction().commit();
			cForm.setCmd("list");
			
		}catch(Exception e){
			ssf.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			ssf.getCurrentSession().close();
		}
		return mapping.findForward("success");
	}

}
