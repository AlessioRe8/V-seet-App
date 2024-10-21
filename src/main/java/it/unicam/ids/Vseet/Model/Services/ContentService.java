package it.unicam.ids.Vseet.Model.Services;


import it.unicam.ids.Vseet.Model.Entities.ContentDTO;
import it.unicam.ids.Vseet.Model.Entities.User;
import it.unicam.ids.Vseet.Model.Exceptions.ContentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService{

    private final POIService poiService;
    private final ItineraryService itineraryService;

    @Autowired
    public ContentService(POIService poiService, ItineraryService itineraryService) {
        this.poiService = poiService;
        this.itineraryService = itineraryService;
    }




    public void createContent(ContentDTO contentDTO, User user) throws ContentNotFoundException {
        if (("ITINERARY").equalsIgnoreCase(contentDTO.getContentCategory().toString())) {
            itineraryService.createItinerary(contentDTO.getName(), contentDTO.getDescription(),
                    user);

        } else if (!("ITINERARY").equalsIgnoreCase(contentDTO.getContentCategory().toString())) {
            poiService.createPointOfInterest(contentDTO.getType(), contentDTO.getName(),
                    contentDTO.getDescription(), contentDTO.getContentCategory(), user,
                    contentDTO.getPosition());
        } else throw new ContentNotFoundException("Unknown content category");
    }
}
