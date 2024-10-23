package it.unicam.ids.Vseet.Model.Services;

import it.unicam.ids.Vseet.Model.Entities.ContentCategory;
import it.unicam.ids.Vseet.Model.Entities.POI.ConcretePointOfInterest;
import it.unicam.ids.Vseet.Model.Entities.POI.LogicPointOfInterest;
import it.unicam.ids.Vseet.Model.Entities.POI.PointOfInterest;
import it.unicam.ids.Vseet.Model.Entities.POI.PointOfInterestFactory;
import it.unicam.ids.Vseet.Model.Entities.Position;
import it.unicam.ids.Vseet.Model.Entities.User;
import it.unicam.ids.Vseet.Model.Repositories.ConcretePOIRepository;
import it.unicam.ids.Vseet.Model.Repositories.LogicPOIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class POIService implements SpringService{
    private PointOfInterestFactory pointOfInterestFactory;
    private ConcretePOIRepository concretePOIRepository;
    private LogicPOIRepository logicPOIRepository;

    @Autowired
    public POIService(PointOfInterestFactory pointOfInterestFactory, ConcretePOIRepository concretePOIRepository,
                      LogicPOIRepository logicPOIRepository) {
        this.pointOfInterestFactory = pointOfInterestFactory;
        this.concretePOIRepository = concretePOIRepository;
        this.logicPOIRepository = logicPOIRepository;
    }

    public PointOfInterest createPointOfInterest(String type, String name, String description,
                                                 ContentCategory category, User creator,
                                                 Position position) {
        PointOfInterest poi = pointOfInterestFactory.createPOI(type, name, description, category,
                creator, position);
        if (poi instanceof ConcretePointOfInterest) {
            concretePOIRepository.save((ConcretePointOfInterest) poi);
        } else if (poi instanceof LogicPointOfInterest) {
            logicPOIRepository.save((LogicPointOfInterest) poi);
        }
        return poi;
    }
}
