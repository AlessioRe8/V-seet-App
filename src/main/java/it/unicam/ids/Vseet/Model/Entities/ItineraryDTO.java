package it.unicam.ids.Vseet.Model.Entities;

public class ItineraryDTO {
    private final String name;
    private final String description;
    private final ContentCategory category;
    public ItineraryDTO(String name, String description, ContentCategory category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ContentCategory getCategory() {
        return category;
    }
}
