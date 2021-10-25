package pe.edu.upc.eatSafe.model.repository.impl;


import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import pe.edu.upc.eatSafe.model.entity.ParkingReservation;
import pe.edu.upc.eatSafe.model.repository.ParkingReservationRepository;

@Named
@ApplicationScoped
public class ParkingReservationImpl implements ParkingReservationRepository{

	@PersistenceContext(unitName = "eatSafePU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<ParkingReservation> findById(Integer id) throws Exception {
		
		return findById(id, ParkingReservation.class);
	}

	@Override
	public List<ParkingReservation> findAll() throws Exception {
		

		String jpql = "SELECT parkingreservation FROM ParkingReservation parkingreservation";
		return findAll(ParkingReservation.class, jpql);
	}
	
	

}
