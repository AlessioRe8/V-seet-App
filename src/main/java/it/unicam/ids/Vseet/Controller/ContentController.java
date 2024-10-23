package it.unicam.ids.Vseet.Controller;

import it.unicam.ids.Vseet.Model.Entities.Content;
import it.unicam.ids.Vseet.Model.Services.ContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contents")
public class ContentController implements SpringController<Content, Long>{
    private final ContentService contentService;

    public ContentController(ContentService contentService){
        this.contentService = contentService;
    }

    @GetMapping
    private String home() {
        return "Homepage";
    }

    @Override
    public ResponseEntity<?> create(@RequestBody Content content) {
        Content savedContent = contentService.createContent(content);
        if (content != null) {
            return new ResponseEntity<>(savedContent, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> getById(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<?> edit(Content entity, Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long aLong) {
        return null;
    }
}
