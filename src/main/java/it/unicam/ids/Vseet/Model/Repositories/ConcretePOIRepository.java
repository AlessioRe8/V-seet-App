package it.unicam.ids.Vseet.Model.Repositories;

import it.unicam.ids.Vseet.Model.Entities.POI.ConcretePointOfInterest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcretePOIRepository extends CrudRepository<ConcretePointOfInterest, Long> {
}
