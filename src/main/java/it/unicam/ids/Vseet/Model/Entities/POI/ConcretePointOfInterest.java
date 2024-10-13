package it.unicam.ids.Vseet.Model.Entities.POI;
import it.unicam.ids.Vseet.Model.Entities.Comune;
import it.unicam.ids.Vseet.Model.Entities.ContentCategory;
import it.unicam.ids.Vseet.Model.Entities.Position;
import it.unicam.ids.Vseet.Model.Entities.User;
import jakarta.persistence.*;

@Entity
public class ConcretePointOfInterest implements PointOfInterest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    private String description;
    private ContentCategory category;
    @ManyToOne
    private User creator;
    @ManyToOne
    private Comune comune;
    @Embedded
    private Position position;

    public ConcretePointOfInterest(String name, String description, ContentCategory category, User creator, Comune comune, Position position) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.creator = creator;
        this.comune = comune;
        this.position = position;
    }

    public ConcretePointOfInterest() {
    }

    @Override
    public Long getId() {
        return ID;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public String getType() {
        return "Concrete";
    }

    @Override
    public Comune getComune() {
        return comune;
    }

    @Override
    public User getCreator() {
        return creator;
    }

    @Override
    public ContentCategory getCategory() {
        return category;
    }
}

