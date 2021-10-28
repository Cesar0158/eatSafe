package pe.edu.upc.eatSafe.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.eatSafe.model.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
	List<Client> findByEmail(String email) throws Exception;
}
