package pe.edu.upc.eatSafe.business.crud.impl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.eatSafe.business.crud.AdminService;
import pe.edu.upc.eatSafe.model.entity.Admin;
import pe.edu.upc.eatSafe.model.repository.AdminRepository;
import pe.edu.upc.eatSafe.model.repository.JpaRepository;

public class AdminServiceImpl implements AdminService {

	@Inject
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
