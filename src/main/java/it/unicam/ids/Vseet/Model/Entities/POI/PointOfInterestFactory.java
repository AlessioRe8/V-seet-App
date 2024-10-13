package it.unicam.ids.Vseet.Model.Entities.POI;

import it.unicam.ids.Vseet.Model.Entities.Comune;
import it.unicam.ids.Vseet.Model.Entities.ContentCategory;
import it.unicam.ids.Vseet.Model.Entities.Position;
import it.unicam.ids.Vseet.Model.Entities.User;

public class PointOfInterestFactory {
    public static PointOfInterest createPOI(String type, String name, String description,
                                            ContentCategory category, User creator, Comune comune,
                                            Position position) {
        if ("CONCRETE".equalsIgnoreCase(type)) {
            return new ConcretePointOfInterest(name, description, category, creator, comune, position);
        } else if ("LOGIC".equalsIgnoreCase(type)) {
            return new LogicPointOfInterest(name, description, category, creator, comune, position);
        } else throw new IllegalArgumentException("Unknown type or not defined.");
    }
}
