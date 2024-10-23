package it.unicam.ids.Vseet.Model.Entities;

import jakarta.persistence.*;
import it.unicam.ids.Vseet.Model.Entities.POI.PointOfInterest;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Itinerary extends Content{
    @OneToMany
    private List<Content> points;

    public Itinerary(String name, String description, User creator,ContentCategory category, List<Content> points) {
        super(name, description, creator, category);
        this.points = points;
    }

    protected Itinerary() {
        super();
    }

    @Override
    public void approve() {
        setApproved(true);
    }

    public List<Content> getPoints() {
        return points;
    }
}
