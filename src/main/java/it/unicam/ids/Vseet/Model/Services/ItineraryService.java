package it.unicam.ids.Vseet.Model.Services;

import it.unicam.ids.Vseet.Model.Entities.Content;
import it.unicam.ids.Vseet.Model.Entities.Itinerary;
import it.unicam.ids.Vseet.Model.Entities.User;
import it.unicam.ids.Vseet.Model.Exceptions.ContentNotFoundException;
import it.unicam.ids.Vseet.Model.Repositories.ItineraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryService implements SpringService{
    ItineraryRepository itineraryRepository;

    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    public Itinerary createItinerary(String name, String description, User creator, List<Content> pointsOfInterest) {
        Itinerary itinerary = new Itinerary(name, description, creator,pointsOfInterest);
        return itineraryRepository.save(itinerary);
    }

    public List<Itinerary> getALlItineraries() {
        return (List<Itinerary>) itineraryRepository.findAll();
    }

    public Itinerary getItineraryById(Long id) {
        return itineraryRepository.findById(id).orElse(null);
    }

    public void deleteItinerary(Long id) {
        itineraryRepository.deleteById(id);
    }
}
