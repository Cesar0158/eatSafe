package pe.edu.upc.eatSafe.business.crud;

import java.util.List;

import pe.edu.upc.eatSafe.model.entity.User;

public interface UserService extends CrudService<User, Integer>{
	List<User> findByEmail(String email) throws Exception;
}
