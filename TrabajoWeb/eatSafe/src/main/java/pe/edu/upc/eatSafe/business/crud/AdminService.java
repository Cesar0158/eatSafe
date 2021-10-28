package pe.edu.upc.eatSafe.business.crud;

import java.util.List;

import pe.edu.upc.eatSafe.model.entity.Admin;

public interface AdminService extends CrudService<Admin, Integer>{
	List<Admin> findByEmail(String email) throws Exception;
}
