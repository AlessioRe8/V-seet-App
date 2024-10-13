package it.unicam.ids.Vseet.Controller;

import it.unicam.ids.Vseet.Model.Entities.Itinerary;
import it.unicam.ids.Vseet.Model.Services.ItineraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itineraries")
public class ItineraryController implements SpringController<Itinerary, Long> {
    private ItineraryService itineraryService;

    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }
    @Override
    public ResponseEntity<?> create(Itinerary entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> getById(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<?> edit(Itinerary entity, Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long aLong) {
        return null;
    }
}
