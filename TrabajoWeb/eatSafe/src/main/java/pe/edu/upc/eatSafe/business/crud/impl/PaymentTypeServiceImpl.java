package pe.edu.upc.eatSafe.business.crud.impl;

import javax.inject.Inject;

import pe.edu.upc.eatSafe.business.crud.PaymentTypeService;
import pe.edu.upc.eatSafe.model.entity.PaymentType;
import pe.edu.upc.eatSafe.model.repository.JpaRepository;
import pe.edu.upc.eatSafe.model.repository.PaymentTypeRepository;

public class PaymentTypeServiceImpl implements PaymentTypeService{

	@Inject
	private PaymentTypeRepository paymenttypeRepository;
	
	@Override
	public JpaRepository<PaymentType, Integer> getJpaRepository() {
		return paymenttypeRepository;
	}

}
