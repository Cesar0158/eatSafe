package pe.edu.upc.eatSafe.model.repository;

import java.util.List;

import pe.edu.upc.eatSafe.model.entity.Opinion;

public interface OpinionRepository extends JpaRepository<Opinion, Integer> {
List<Opinion> findByName(String name) throws Exception;
}
