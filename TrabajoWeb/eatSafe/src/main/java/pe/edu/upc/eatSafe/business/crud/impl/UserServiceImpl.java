package pe.edu.upc.eatSafe.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.eatSafe.business.crud.UserService;
import pe.edu.upc.eatSafe.model.entity.User;
import pe.edu.upc.eatSafe.model.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public JpaRepository<User, Integer> getJpaRepository() {
		return userRepository;
	}

	@Override
	public List<User> findByEmail(String email) throws Exception {
		return userRepository.findByEmail(email);
	}

}
