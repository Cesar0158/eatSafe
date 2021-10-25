package pe.edu.upc.eatSafe.model.repository;

import java.util.List;

import pe.edu.upc.eatSafe.model.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	List<Client> findByEmail(String email) throws Exception;
}
