/*package pe.edu.upc.eatSafe.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.eatSafe.business.crud.OpinionService;
import pe.edu.upc.eatSafe.model.entity.Opinion;
import pe.edu.upc.eatSafe.model.repository.OpinionRepository;

@Service
public class OpinionServiceImpl implements OpinionService {

	@Autowired
	private OpinionRepository opinionRepository;
	
	@Override
	public JpaRepository<Opinion, Integer> getJpaRepository(){
		return opinionRepository;
	}
	
	@Override
	public List<Opinion> findByName(String comment) throws Exception{
		return opinionRepository.findByName(comment);
	}
}*/
