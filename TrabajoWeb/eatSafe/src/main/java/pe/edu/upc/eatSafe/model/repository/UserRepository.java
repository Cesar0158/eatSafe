package pe.edu.upc.eatSafe.model.repository;

import java.util.List;

import pe.edu.upc.eatSafe.model.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByEmail(String email) throws Exception;
}
