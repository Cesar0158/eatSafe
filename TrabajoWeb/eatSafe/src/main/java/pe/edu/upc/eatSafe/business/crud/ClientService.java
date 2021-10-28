package pe.edu.upc.eatSafe.business.crud;

import java.util.List;

import pe.edu.upc.eatSafe.model.entity.Client;

public interface ClientService extends CrudService<Client, Integer>{
	List<Client> findByEmail(String email) throws Exception;
}
