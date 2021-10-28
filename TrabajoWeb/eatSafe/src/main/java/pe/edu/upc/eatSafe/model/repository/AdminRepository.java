package pe.edu.upc.eatSafe.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.eatSafe.model.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	List<Admin> findByEmail(String email) throws Exception;
}
