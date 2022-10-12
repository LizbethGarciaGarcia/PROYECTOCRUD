package org.action.register;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dao.register.DaoImplRegister;
import org.dao.register.DaoRegister;
import org.modelo.register.Register;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@SuppressWarnings("serial")
public class ActionRegister  extends ActionSupport implements ModelDriven<Register>{
		private Register register = new Register();
	    private DaoRegister dao = new DaoImplRegister();
	    private List<Register> listRegister = new ArrayList<Register>();
	    
	    public String execute() {
	    	return SUCCESS;
	    }
	    
	    public String addRegister() {
	    	dao.addRegister(register);
	    	return SUCCESS;
	    }
	
	    public String listRegister() {
	    	setListRegister(dao.listRegister());
	    	return SUCCESS;
	    }
	    
	    //HTTPSERVLETREQUEST : PERMITE RECUPERAR EL VALOR DE UNA VARIABLE EN MEMORIA
	    public String updateRegister() {
	    	HttpServletRequest request = (HttpServletRequest)
	    	ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	    	register = dao.getRegisterById(Integer.parseInt(request.getParameter("id")));
	    	return SUCCESS;
	    }
	    
	    public String deleteRegister() {
	    	HttpServletRequest request = (HttpServletRequest)
	    	ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	    	dao.deleteRegister(Integer.parseInt(request.getParameter("id")));
	    	return SUCCESS;
	    }
	   
	    //GETTERS AND SETTERS
	    public Register getRegister() {
			return register;
		}

		public void setRegister(Register register) {
			this.register = register;
		}

		public List<Register> getListRegister() {
			return listRegister;
		}

		public void setListRegister(List<Register> listRegister) {
			this.listRegister = listRegister;
		}
		
		 
	    //GETMODEL RETORNS OBJ
	    @Override
		public Register getModel() {
			return register;
		}
	    

		

		
	
}
