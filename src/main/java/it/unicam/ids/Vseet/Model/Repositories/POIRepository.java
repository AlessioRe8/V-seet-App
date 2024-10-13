package it.unicam.ids.Vseet.Model.Repositories;

import it.unicam.ids.Vseet.Model.Entities.POI.PointOfInterest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface POIRepository extends CrudRepository<PointOfInterest, Long> {
}
