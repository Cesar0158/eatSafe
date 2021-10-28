package pe.edu.upc.eatSafe.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.eatSafe.business.crud.AdminService;
import pe.edu.upc.eatSafe.model.entity.Admin;
import pe.edu.upc.eatSafe.model.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public JpaRepository<Admin, Integer> getJpaRepository() {
		return adminRepository;
	}

	@Override
	public List<Admin> findByEmail(String email) throws Exception {
		return adminRepository.findByEmail(email);
	}

}
