package pe.edu.upc.eatSafe.business.crud.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.eatSafe.business.crud.ParkingReservationService;
import pe.edu.upc.eatSafe.model.entity.ParkingReservation;
import pe.edu.upc.eatSafe.model.repository.ParkingReservationRepository;

@Service
public class ParkingReservationServiceImpl implements ParkingReservationService{

	@Autowired
	private ParkingReservationRepository parkingreservationRepository;
	
	@Override
	public JpaRepository<ParkingReservation, Integer> getJpaRepository() {
		return parkingreservationRepository;
	}

}
