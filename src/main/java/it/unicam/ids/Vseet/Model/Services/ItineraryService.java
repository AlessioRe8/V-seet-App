package it.unicam.ids.Vseet.Model.Services;

import it.unicam.ids.Vseet.Model.Repositories.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItineraryService implements SpringService{
    ItineraryRepository itineraryRepository;

    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }
}
