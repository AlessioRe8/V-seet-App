package it.unicam.ids.Vseet.Controller;

import it.unicam.ids.Vseet.Model.Entities.Content;
import it.unicam.ids.Vseet.Model.Exceptions.ContentNotFoundException;
import it.unicam.ids.Vseet.Model.Services.ContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contents")
public class ContentController {
    private final ContentService contentService;

    public ContentController(ContentService contentService){
        this.contentService = contentService;
    }

    public ResponseEntity<?> create(@RequestBody Content content) {
        Content savedContent = contentService.createContent(content);
        if (content != null) {
            return new ResponseEntity<>(savedContent, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('PLATFORM_MANAGER') || hasRole('CURATOR') || hasRole('ANIMATOR')")
    @PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestParam("id") Long id) throws ContentNotFoundException {
        return new ResponseEntity<>(contentService.verify(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(contentService.getAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('PLATFORM_MANAGER') || hasRole('CURATOR') || hasRole('ANIMATOR')")
    @GetMapping("/unverified")
    public ResponseEntity<?> getAllUnverified() {
        return new ResponseEntity<>(contentService.getAllUnverified(), HttpStatus.OK);
    }

    public ResponseEntity<?> getById(@RequestParam("id") Long id) throws ContentNotFoundException{
        return new ResponseEntity<>(contentService.getById(id), HttpStatus.OK);
    }


    public ResponseEntity<?> edit(Content entity, Long aLong) {
        return null;
    }

    public ResponseEntity<?> delete(Long aLong) {
        return null;
    }
}
