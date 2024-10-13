package it.unicam.ids.Vseet.Model.Repositories;

import it.unicam.ids.Vseet.Model.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findById(long id);
}
