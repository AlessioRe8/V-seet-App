package it.unicam.ids.Vseet.Model.Repositories;

import it.unicam.ids.Vseet.Model.Entities.POI.LogicPointOfInterest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogicPOIRepository extends CrudRepository<LogicPointOfInterest, Long> {
}
