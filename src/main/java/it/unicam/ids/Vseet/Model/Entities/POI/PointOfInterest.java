package it.unicam.ids.Vseet.Model.Entities.POI;

import it.unicam.ids.Vseet.Model.Entities.*;
import jakarta.persistence.*;

public interface PointOfInterest {
    Long getId();
    String getName();
    String getDescription();
    Position getPosition();
    String getType();
    Comune getComune();
    User getCreator();
    ContentCategory getCategory();
}
