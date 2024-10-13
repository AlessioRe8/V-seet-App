package it.unicam.ids.Vseet.Model.Services;

import it.unicam.ids.Vseet.Model.Entities.User;
import it.unicam.ids.Vseet.Model.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements SpringService{
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
