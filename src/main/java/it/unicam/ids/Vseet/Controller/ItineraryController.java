package it.unicam.ids.Vseet.Controller;

import it.unicam.ids.Vseet.Model.Entities.Itinerary;
import it.unicam.ids.Vseet.Model.Entities.ItineraryDTO;
import it.unicam.ids.Vseet.Model.Exceptions.ContentNotFoundException;
import it.unicam.ids.Vseet.Model.Services.ItineraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itineraries")
public class ItineraryController {
    private ItineraryService itineraryService;

    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @PreAuthorize("hasRole('CONTRIBUTOR') || hasRole('TOURIST') || hasRole('PLATFORM_MANAGER') ||" +
            " hasRole('ANIMATOR') || hasRole('AUTHORIZED_CONTRIBUTOR') || hasRole('CURATOR')")
    @PostMapping("/create")
    public ResponseEntity<?> createUnverified(@RequestPart("itinerary") ItineraryDTO itinerary) {
        Itinerary savedItinerary = itineraryService.create(itinerary);
        if (savedItinerary != null) {
            return new ResponseEntity<>(savedItinerary, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('PLATFORM_MANAGER') || hasRole('ANIMATOR') || hasRole('AUTHORIZED_CONTRIBUTOR') || hasRole('CURATOR')")
    @PostMapping("/create/verified")
    public ResponseEntity<?> createVerified(@RequestPart("itinerary") ItineraryDTO itinerary) {
        Itinerary savedItinerary = itineraryService.createVerified(itinerary);
        if (savedItinerary != null) {
            return new ResponseEntity<>(savedItinerary, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> getById(@RequestParam("id") Long id) throws ContentNotFoundException{
        return new ResponseEntity<>(itineraryService.getItineraryById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(itineraryService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam("id") Long id) throws ContentNotFoundException {
        itineraryService.deleteItinerary(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Adds a content to an already existing itinerary
    @PostMapping("/add")
    public ResponseEntity<?> addContent(@RequestParam("idItinerary") Long idItinerary,
                                        @RequestParam("idContent") Long idContent) throws ContentNotFoundException {
        return new ResponseEntity<>(itineraryService.addContent(idItinerary, idContent), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> edit(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
