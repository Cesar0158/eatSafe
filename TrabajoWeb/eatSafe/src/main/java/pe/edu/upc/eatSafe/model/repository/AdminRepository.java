package pe.edu.upc.eatSafe.model.repository;

import java.util.List;

import pe.edu.upc.eatSafe.model.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	List<Admin> findByEmail(String email) throws Exception;
}
