package it.unicam.ids.Vseet.Model.Entities.POI;
import it.unicam.ids.Vseet.Model.Entities.*;
import jakarta.persistence.*;

@Entity
public class ConcretePointOfInterest extends Content implements PointOfInterest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    private String description;
    private ContentCategory category;
    @ManyToOne
    private User creator;
    @Embedded
    private Position position;

    public ConcretePointOfInterest(String name, String description, ContentCategory category, User creator, Position position) {
        super();
        this.name = name;
        this.description = description;
        this.category = category;
        this.creator = creator;
        this.position = position;
    }

    public ConcretePointOfInterest() {
        super();
    }

    @Override
    public void approve() {
        setApproved(true);
    }

    @Override
    public String getType() {
        return "Concrete";
    }


    public Long getId() {
        return ID;
    }

    public String getName() {
        return name;
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

    public ContentCategory getCategory() {
        return category;
    }
}

