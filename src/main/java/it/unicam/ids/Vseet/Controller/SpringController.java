package it.unicam.ids.Vseet.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Interface made for understanding the contract of the basic SpringBoot Controller.
 * @param <T>   the entity parsed to the controller
 * @param <ID>  the ID of the entity parsed to the controller
 */
public interface SpringController<T, ID> {

    /**
     * Post request to create an instance of the entity.
     * @param entity
     * @return the result
     */
    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody T entity);

    /**
     * The get request to return all the entities.
     * @return the result
     */
    @GetMapping("/getAll")
    ResponseEntity<?> getAll();

    /**
     * The get request to return an entity providing its ID.
     * @param id
     * @return  the result
     */
    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable ID id);

    /**
     * Put request to edit an entity in the app.
     * @param entity
     * @param id
     * @return the result
     */
    @PutMapping
    ResponseEntity<?> edit(@RequestBody T entity, @PathVariable ID id);

    /**
     * The delete request to delete an entity providing its ID.
     * @param id
     * @return the result
     */
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable ID id);

}
