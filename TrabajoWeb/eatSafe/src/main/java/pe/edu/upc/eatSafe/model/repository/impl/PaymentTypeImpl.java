package pe.edu.upc.eatSafe.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import pe.edu.upc.eatSafe.model.entity.PaymentType;
import pe.edu.upc.eatSafe.model.repository.PaymentTypeRepository;


@Named
@ApplicationScoped
public class PaymentTypeImpl implements PaymentTypeRepository{

	@PersistenceContext(unitName = "eatSafePU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<PaymentType> findById(Integer id) throws Exception {
		return findById(id, PaymentType.class);	
	}

	@Override
	public List<PaymentType> findAll() throws Exception {
				
		
		String jpql = "SELECT paymenttype FROM PaymentType paymenttype";
		return findAll(PaymentType.class, jpql);
	}

}
