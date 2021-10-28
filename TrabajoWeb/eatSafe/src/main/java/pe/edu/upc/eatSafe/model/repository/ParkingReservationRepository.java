package pe.edu.upc.eatSafe.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.eatSafe.model.entity.ParkingReservation;

@Repository
public interface ParkingReservationRepository extends JpaRepository<ParkingReservation,Integer>{

}
