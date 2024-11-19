package it.unicam.ids.Vseet.Model.Services;

import it.unicam.ids.Vseet.Model.Entities.POI.*;
import it.unicam.ids.Vseet.Model.Entities.User;
import it.unicam.ids.Vseet.Model.Exceptions.ContentNotFoundException;
import it.unicam.ids.Vseet.Model.Repositories.ConcretePOIRepository;
import it.unicam.ids.Vseet.Model.Repositories.ContentRepository;
import it.unicam.ids.Vseet.Model.Repositories.LogicPOIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class POIService {
    private final PointOfInterestFactory pointOfInterestFactory;
    private final ConcretePOIRepository concretePOIRepository;
    private final LogicPOIRepository logicPOIRepository;
    private final UserService userService;
    private final ContentRepository contentRepository;

    @Autowired
    public POIService(PointOfInterestFactory pointOfInterestFactory, ConcretePOIRepository concretePOIRepository,
                      LogicPOIRepository logicPOIRepository, UserService userService, ContentRepository contentRepository) {
        this.pointOfInterestFactory = pointOfInterestFactory;
        this.concretePOIRepository = concretePOIRepository;
        this.logicPOIRepository = logicPOIRepository;
        this.userService = userService;
        this.contentRepository = contentRepository;
    }


    public PointOfInterest getById(Long id) throws ContentNotFoundException {
        if (concretePOIRepository.existsById(id)) {
            return concretePOIRepository.findById(id).orElseThrow(ContentNotFoundException::new);
        }else if (logicPOIRepository.existsById(id)) {
          return logicPOIRepository.findById(id).orElseThrow(ContentNotFoundException::new);
        } else throw new ContentNotFoundException();
    }

    public List<PointOfInterest> getAll() {
        List<PointOfInterest> pointOfInterests = new ArrayList<>();
        logicPOIRepository.findAll().forEach(pointOfInterests::add);
        concretePOIRepository.findAll().forEach(pointOfInterests::add);
        return pointOfInterests;
    }

    public PointOfInterest createPointOfInterest(PointOfInterestDTO pointOfInterest, String type) {
        //sets the creator as the authenticated user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) auth.getPrincipal()).getUsername();
        User user = userService.getByUsername(username);

        PointOfInterest poi = pointOfInterestFactory.createPOI(type, pointOfInterest.getName(),
                pointOfInterest.getDescription(), pointOfInterest.getCategory(), user, pointOfInterest.getPosition());
        if (poi instanceof ConcretePointOfInterest) {
            ConcretePointOfInterest concretePOI = (ConcretePointOfInterest) poi;
            contentRepository.save(concretePOI);
            return concretePOIRepository.save(concretePOI);
        } else if (poi instanceof LogicPointOfInterest) {
            LogicPointOfInterest logicPOI = (LogicPointOfInterest) poi;
            contentRepository.save(logicPOI);
            return logicPOIRepository.save(logicPOI);
        } else throw new IllegalArgumentException("Unknown point of interest type.");
    }
    public PointOfInterest createVerifiedPointOfInterest(PointOfInterestDTO pointOfInterest, String type) {
        //sets the creator as the authenticated user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) auth.getPrincipal()).getUsername();
        User user = userService.getByUsername(username);

        PointOfInterest poi = pointOfInterestFactory.createPOI(type, pointOfInterest.getName(),
                pointOfInterest.getDescription(), pointOfInterest.getCategory(), user, pointOfInterest.getPosition());
        if (poi instanceof ConcretePointOfInterest) {
            ConcretePointOfInterest concretePOI = (ConcretePointOfInterest) poi;
            concretePOI.verify();
            contentRepository.save(concretePOI);
            return concretePOIRepository.save(concretePOI);
        } else if (poi instanceof LogicPointOfInterest) {
            LogicPointOfInterest logicPOI = (LogicPointOfInterest) poi;
            logicPOI.verify();
            contentRepository.save(logicPOI);
            return logicPOIRepository.save(logicPOI);
        } else throw new IllegalArgumentException("Unknown point of interest type.");
    }

    public void deleteById(Long id) throws ContentNotFoundException {
        if (concretePOIRepository.existsById(id)) {
            contentRepository.deleteById(id);
            concretePOIRepository.deleteById(id);
        } else if (logicPOIRepository.existsById(id)) {
            contentRepository.deleteById(id);
            logicPOIRepository.deleteById(id);
        } else {
            throw new ContentNotFoundException();
        }
    }

}
