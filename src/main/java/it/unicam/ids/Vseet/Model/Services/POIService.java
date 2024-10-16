package it.unicam.ids.Vseet.Model.Services;

import it.unicam.ids.Vseet.Model.Entities.ContentCategory;
import it.unicam.ids.Vseet.Model.Entities.POI.PointOfInterest;
import it.unicam.ids.Vseet.Model.Entities.POI.PointOfInterestFactory;
import it.unicam.ids.Vseet.Model.Entities.Position;
import it.unicam.ids.Vseet.Model.Entities.User;
import it.unicam.ids.Vseet.Model.Repositories.POIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class POIService implements SpringService{
    private PointOfInterestFactory pointOfInterestFactory;
    private POIRepository poiRepository;

    @Autowired
    public POIService(PointOfInterestFactory pointOfInterestFactory, POIRepository poiRepository) {
        this.pointOfInterestFactory = pointOfInterestFactory;
        this.poiRepository = poiRepository;
    }

    public PointOfInterest createPointOfInterest(String type, String name, String description,
                                                 ContentCategory category, User creator,
                                                 Position position) {
        PointOfInterest poi = pointOfInterestFactory.createPOI(type, name, description, category,
                creator, position);
        return poiRepository.save(poi);
    }
}
