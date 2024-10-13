package it.unicam.ids.Vseet.Controller;

import it.unicam.ids.Vseet.Model.Entities.User;
import it.unicam.ids.Vseet.Model.Repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController implements SpringController<User, Long> {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<?> create(User entity) {
        return null;
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
    public ResponseEntity<?> edit(User entity, Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long aLong) {
        return null;
    }
}
