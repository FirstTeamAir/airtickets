package ru.vsu.rest.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.service.model.create.UserCreateDto;
import ru.vsu.service.model.get.UserGetDto;
import ru.vsu.service.model.update.UserUpdateDto;
import ru.vsu.service.service.IUserService;

import java.util.List;

/**
 * Controller class for managing users.
 *
 * @author Ignatov Mikhail
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService service;

    /**
     * Constructor.
     */
    public UserController(IUserService service) {
        this.service = service;
    }

    /**
     * Creates an instance in database with information provided in DTO.
     *
     * @param createDto DTO that holds information about entity to save
     * @return Dto from saved entity
     */
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserGetDto create(@RequestBody UserCreateDto createDto) {
        return service.create(createDto);
    }

    /**
     * Updates the user by id.
     *
     * @param id        identifier used to find existing user
     * @param updateDto DTO that holds information about new entity
     * @return Dto from updated entity or null
     */
    @PutMapping(path = "/{id}")
    public UserGetDto updateById(@PathVariable int id,
                                   @RequestBody UserUpdateDto updateDto) {
        return service.updateById(id, updateDto);
    }

    /**
     * Deletes the user by id.
     *
     * @param id identifier used to find existing user
     */
    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }

    /**
     * Fetches instance of {@link UserGetDto} by id.
     *
     * @param id for search by id
     */
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserGetDto getById(@PathVariable("id") int id) {
        return service.getById(id);
    }

    /**
     * Fetches a list of {@link UserGetDto} instances.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserGetDto> getAll() {
        return service.getAll();
    }
}