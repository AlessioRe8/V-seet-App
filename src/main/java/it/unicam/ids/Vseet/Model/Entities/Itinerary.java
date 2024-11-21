package it.unicam.ids.Vseet.Model.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Itinerary extends Content{
    @OneToMany
    private List<Content> points;

    public Itinerary(String name, String description, User creator, ContentCategory category) {
        super(name, description, creator, category);
    }

    protected Itinerary() {
        super();
    }

    public void addContent(Content content) {
        points.add(content);
    }

    public void setPoints(List<Content> points) {
        this.points = points;
    }
    public List<Content> getPoints() {
        return points;
    }

}
