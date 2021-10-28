package pe.edu.upc.eatSafe.business.crud.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.eatSafe.business.crud.PaymentTypeService;
import pe.edu.upc.eatSafe.model.entity.PaymentType;
import pe.edu.upc.eatSafe.model.repository.PaymentTypeRepository;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService{

	@Autowired
	private PaymentTypeRepository paymenttypeRepository;
	
	@Override
	public JpaRepository<PaymentType, Integer> getJpaRepository() {
		return paymenttypeRepository;
	}

}
