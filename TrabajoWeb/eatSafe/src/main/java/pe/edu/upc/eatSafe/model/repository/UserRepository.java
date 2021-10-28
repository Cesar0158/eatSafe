package pe.edu.upc.eatSafe.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.eatSafe.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByEmail(String email) throws Exception;
}
