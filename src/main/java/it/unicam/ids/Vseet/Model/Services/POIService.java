package it.unicam.ids.Vseet.Model.Services;

import it.unicam.ids.Vseet.Model.Repositories.POIRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class POIService implements SpringService{
    private POIRepository poiRepository;

    public POIService(POIRepository poiRepository) {
        this.poiRepository = poiRepository;
    }
}
