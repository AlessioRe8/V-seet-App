package it.unicam.ids.Vseet.Model.Repositories;

import it.unicam.ids.Vseet.Model.Entities.POI.ConcretePointOfInterest;
import org.springframework.data.repository.CrudRepository;

public interface ConcretePOIRepository extends CrudRepository<ConcretePointOfInterest, Long> {
}
