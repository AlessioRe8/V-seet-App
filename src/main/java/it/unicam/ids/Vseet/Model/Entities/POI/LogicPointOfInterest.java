package it.unicam.ids.Vseet.Model.Entities.POI;

import it.unicam.ids.Vseet.Model.Entities.*;
import jakarta.persistence.*;

@Entity
public class LogicPointOfInterest extends Content implements PointOfInterest {
    @Embedded
    private Position position;

    public LogicPointOfInterest(String name, String description, ContentCategory category, User creator, Position position) {
        super(name, description, creator, category);
        this.position = position;
    }

    public LogicPointOfInterest() {
        super();
    }
    @Override
    public String getType() {
        return "Logic";
    }

    public Position getPosition() {
        return position;
    }
}
