package pe.edu.upc.eatSafe.business.crud.impl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.eatSafe.business.crud.OpinionService;
import pe.edu.upc.eatSafe.model.entity.Opinion;
import pe.edu.upc.eatSafe.model.repository.JpaRepository;
import pe.edu.upc.eatSafe.model.repository.OpinionRepository;

public class OpinionServiceImpl implements OpinionService {

	@Inject
	private OpinionRepository opinionRepository;
	
	@Override
	public JpaRepository<Opinion, Integer> getJpaRepository(){
		return opinionRepository;
	}
	
	@Override
	public List<Opinion> findByName(String name) throws Exception{
		return opinionRepository.findByName(name);
	}
}
