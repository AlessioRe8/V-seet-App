package it.unicam.ids.Vseet.Controller;

import it.unicam.ids.Vseet.Model.Entities.ContentDTO;
import it.unicam.ids.Vseet.Model.Entities.User;
import it.unicam.ids.Vseet.Model.Entities.UserRole;
import it.unicam.ids.Vseet.Model.Services.ContentService;
import it.unicam.ids.Vseet.Model.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contents")
public class ContentController {
    private ContentService contentService;
    private UserService userService;

    public ContentController(ContentService contentService, UserService userService) {
        this.contentService = contentService;
        this.userService = userService;
    }
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody ContentDTO contentDTO, Authentication authentication) {
        String username = authentication.getName();
        User user = userService.findByUsername(username);

        if (user.getRole() == UserRole.CONTRIBUTOR || user.getRole() == UserRole.CURATOR) {
            try {
                contentService.createContent(contentDTO, user);
                return new ResponseEntity<>("Content uploaded successfully!", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("User not authorized to upload content.", HttpStatus.FORBIDDEN);
        }
    }
}
