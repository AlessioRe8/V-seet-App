package it.unicam.ids.Vseet.Model.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Itinerary<Content>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    private String description;
    @ManyToOne
    private User creator;

    @ManyToMany
    private final List<Content> contents = new ArrayList<>();

    public Itinerary(String name, String description, User creator) {
        this.name = name;
        this.description = description;
        this.creator = creator;
    }

    protected Itinerary() {
    }

    public List<Content> getContents() {
        return contents;
    }
}
