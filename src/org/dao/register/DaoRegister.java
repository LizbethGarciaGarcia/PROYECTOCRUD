package org.dao.register;

import java.util.List;

import org.modelo.register.Register;

public interface DaoRegister {
	
	public void addRegister(Register register);
	public List<Register> listRegister();
	public Register getRegisterById(int id);
	public void deleteRegister(int id);

}
