package it.unicam.ids.Vseet.Controller;

import it.unicam.ids.Vseet.Model.Entities.POI.PointOfInterest;
import it.unicam.ids.Vseet.Model.Repositories.POIRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poi")
public class POIController implements SpringController<PointOfInterest, Long> {

    private POIRepository poiRepository;

    public POIController(POIRepository poiRepository) {
        this.poiRepository = poiRepository;
    }

    @Override
    public ResponseEntity<?> create(PointOfInterest entity) {
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
