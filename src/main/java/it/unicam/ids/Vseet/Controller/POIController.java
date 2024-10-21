package it.unicam.ids.Vseet.Controller;

import it.unicam.ids.Vseet.Model.Entities.POI.PointOfInterest;
import it.unicam.ids.Vseet.Model.Services.POIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poi")
public class POIController implements SpringController<PointOfInterest, Long> {

    private final POIService poiService;

    @Autowired
    public POIController(POIService poiService) {
        this.poiService = poiService;
    }

    @Override
    public ResponseEntity<?> create(PointOfInterest pointOfInterest) {
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
    public ResponseEntity<?> edit(PointOfInterest entity, Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long aLong) {
        return null;
    }
}
