package pe.edu.upc.eatSafe.business.crud;

import java.util.List;

import pe.edu.upc.eatSafe.model.entity.Opinion;

public interface OpinionService extends CrudService<Opinion, Integer>{
List<Opinion> findByName(String name) throws Exception;
}
