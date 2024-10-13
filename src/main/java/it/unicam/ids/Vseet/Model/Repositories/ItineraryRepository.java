package it.unicam.ids.Vseet.Model.Repositories;

import it.unicam.ids.Vseet.Model.Entities.Itinerary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraryRepository extends CrudRepository<Itinerary, Long> {
}
