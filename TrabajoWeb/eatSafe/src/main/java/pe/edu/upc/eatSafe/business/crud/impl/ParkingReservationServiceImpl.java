package pe.edu.upc.eatSafe.business.crud.impl;

import javax.inject.Inject;

import pe.edu.upc.eatSafe.business.crud.ParkingReservationService;
import pe.edu.upc.eatSafe.model.entity.ParkingReservation;
import pe.edu.upc.eatSafe.model.repository.JpaRepository;
import pe.edu.upc.eatSafe.model.repository.ParkingReservationRepository;

public class ParkingReservationServiceImpl implements ParkingReservationService{

	@Inject
	private ParkingReservationRepository parkingreservationRepository;
	
	@Override
	public JpaRepository<ParkingReservation, Integer> getJpaRepository() {
		return parkingreservationRepository;
	}

}
