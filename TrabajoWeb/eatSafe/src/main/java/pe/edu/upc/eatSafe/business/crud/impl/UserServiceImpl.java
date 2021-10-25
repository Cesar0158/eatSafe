package pe.edu.upc.eatSafe.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.eatSafe.business.crud.UserService;
import pe.edu.upc.eatSafe.model.entity.User;
import pe.edu.upc.eatSafe.model.repository.JpaRepository;
import pe.edu.upc.eatSafe.model.repository.UserRepository;

@Named
@ApplicationScoped
public class UserServiceImpl implements UserService {

	@Inject
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
