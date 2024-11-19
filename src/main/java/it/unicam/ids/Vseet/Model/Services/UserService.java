package it.unicam.ids.Vseet.Model.Services;

import it.unicam.ids.Vseet.Model.Entities.User;
import it.unicam.ids.Vseet.Model.Entities.UserRole;
import it.unicam.ids.Vseet.Model.Exceptions.UserAlreadyExistsException;
import it.unicam.ids.Vseet.Model.Exceptions.UserNotFoundException;
import it.unicam.ids.Vseet.Model.Repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null ||
                userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistsException();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAll(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User getById(Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public void deleteById(Long id) throws UserNotFoundException{
        if(!userRepository.existsById(id)) throw new UserNotFoundException();
        userRepository.deleteById(id);
    }

    public User editUserRole(Long id, UserRole newRole) throws UserNotFoundException{
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        user.setRole(newRole);
        return userRepository.save(user);
    }

    @PostConstruct
    public void loadUsers() {
        User user1 = new User("Alessio", passwordEncoder.encode("password"), "alessio.re@example.it", UserRole.PLATFORM_MANAGER);
        User user2 = new User("Andrea", passwordEncoder.encode("password"), "andrea.bianchi@example.it", UserRole.ANIMATOR);
        User user3 = new User("Mario", passwordEncoder.encode("password"), "mario.rossi@example.it", UserRole.AUTHENTICATED_TOURIST);
        User user4 = new User("Anna", passwordEncoder.encode("password"), "anna.verdi@example.it", UserRole.TOURIST);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
    }
}
