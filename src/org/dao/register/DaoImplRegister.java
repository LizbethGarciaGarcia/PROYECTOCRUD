package org.dao.register;

import java.util.List;

import javax.transaction.Transaction;
import org.hibernate.classic.Session;
import org.modelo.register.Register;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;


public class DaoImplRegister implements DaoRegister {
	@SessionTarget
	private Session session;
	
	@TransactionTarget
	private  Transaction transaction;

	@Override
	public void addRegister(Register register) {
		try {
			System.out.println(register.getCiudad()+","+register.getGenero()+","+register.getNombre());
			session.saveOrUpdate(register);
		} catch (Exception e) {
			System.out.println("EXCEPTION: "+ e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Register> listRegister() {
		List<Register> list = null;
		try {
			list = (List<Register>) session.createQuery("from Register").list();
		} catch (Exception e) {
			System.out.println("EXCEPTION: "+ e.getMessage());
		}
		return list;
	}

	@Override
	public Register getRegisterById(int id) {
		Register register = null;
		try {
			register = (Register) session.get(Register.class, id);
		} catch (Exception e) {
			System.out.println("EXCEPTION: "+ e.getMessage());
		}
		return register;
	}

	@Override
	public void deleteRegister(int id) {
		Register register = null;
		try {
			register = (Register) session.get(Register.class, id);
			session.delete(register);
		} catch (Exception e) {
			System.out.println("EXCEPTION: "+ e.getMessage());
		}
		
	}

}
