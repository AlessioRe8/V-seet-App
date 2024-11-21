package it.unicam.ids.Vseet.Model.Services;

import it.unicam.ids.Vseet.Model.Entities.*;
import it.unicam.ids.Vseet.Model.Exceptions.ContentNotFoundException;
import it.unicam.ids.Vseet.Model.Repositories.ContentRepository;
import it.unicam.ids.Vseet.Model.Repositories.ItineraryRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItineraryService {
    private final ItineraryRepository itineraryRepository;
    private final UserService userService;
    private final ContentRepository contentRepository;

    public ItineraryService(ItineraryRepository itineraryRepository, ContentRepository contentRepository,
                            UserService userService) {
        this.itineraryRepository = itineraryRepository;
        this.contentRepository = contentRepository;
        this.userService = userService;
    }

    public Itinerary create(ItineraryDTO itDTO) {
        //sets the creator as the authenticated user.
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) auth.getPrincipal()).getUsername();
        User user = userService.getByUsername(username);

        Itinerary itinerary = new Itinerary(itDTO.getName(), itDTO.getDescription(),user, itDTO.getCategory());
        contentRepository.save(itinerary);
        return itineraryRepository.save(itinerary);
    }

    public Itinerary createVerified(ItineraryDTO itDTO) {
        //sets the creator as the authenticated user.
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) auth.getPrincipal()).getUsername();
        User user = userService.getByUsername(username);

        Itinerary itinerary = new Itinerary(itDTO.getName(), itDTO.getDescription(),user, itDTO.getCategory());
        itinerary.verify();
        contentRepository.save(itinerary);
        return itineraryRepository.save(itinerary);
    }

    public List<Itinerary> getAll() {
        List<Itinerary> itineraries = new ArrayList<>();
        itineraryRepository.findAll().forEach(itineraries::add);
        return itineraries;
    }

    public Itinerary getItineraryById(Long id) throws ContentNotFoundException{
        return itineraryRepository.findById(id).orElseThrow(ContentNotFoundException::new);
    }

    public void deleteItinerary(Long id) throws ContentNotFoundException {
        if (!itineraryRepository.existsById(id)) {
            throw new ContentNotFoundException();
        } else {
            contentRepository.deleteById(id);
            itineraryRepository.deleteById(id);
        }
    }

    public Itinerary addContent(Long idItinerary, Long idContent) throws ContentNotFoundException{
        Itinerary itinerary = itineraryRepository.findById(idItinerary).orElse(null);
        if (itinerary != null) {
            itinerary.addContent(contentRepository.findById(idContent).orElseThrow(ContentNotFoundException::new));
            itineraryRepository.save(itinerary);
            contentRepository.save(itinerary);
            return itinerary;
        } else {
            throw new ContentNotFoundException();
        }
    }
}
