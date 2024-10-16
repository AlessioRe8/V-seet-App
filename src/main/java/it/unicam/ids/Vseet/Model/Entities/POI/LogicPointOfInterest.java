package it.unicam.ids.Vseet.Model.Entities.POI;

import it.unicam.ids.Vseet.Model.Entities.*;
import jakarta.persistence.*;

@Entity
public class LogicPointOfInterest extends Content implements PointOfInterest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    private String description;
    private ContentCategory category;
    @Embedded
    private Position position;
    @ManyToOne
    private User creator;

    public LogicPointOfInterest(String name, String description, ContentCategory category, User creator, Position position) {
        super();
        this.name = name;
        this.description = description;
        this.category = category;
        this.creator = creator;
        this.position = position;
    }

    public LogicPointOfInterest() {
        super();
    }
    public String getName() {
        return name;
    }

    public Long getId() {
        return ID;
    }

    @Override
    public void approve() {
        setApproved(true);
    }
    @Override
    public String getType() {
        return "Logic";
    }

    public String getDescription() {
        return description;
    }

    public Position getPosition() {
        return position;
    }
    public User getCreator() {
        return creator;
    }
    public ContentCategory getCategory(){
        return category;
    }
}
