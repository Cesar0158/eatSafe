package pe.edu.upc.eatSafe.model.repository;

import java.util.List;

import pe.edu.upc.eatSafe.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	List<Category> findByName(String name) throws Exception;
}
