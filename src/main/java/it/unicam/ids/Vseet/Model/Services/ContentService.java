package it.unicam.ids.Vseet.Model.Services;

import it.unicam.ids.Vseet.Model.Entities.Content;
import it.unicam.ids.Vseet.Model.Repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService implements SpringService{
    private ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public Content createContent(Content content) {
        return contentRepository.save(content);
    }
}
