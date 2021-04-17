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
import ru.vsu.service.model.create.TicketCreateDto;
import ru.vsu.service.model.get.TicketGetDto;
import ru.vsu.service.model.update.TicketUpdateDto;
import ru.vsu.service.service.ITicketService;

import java.util.List;

/**
 * Controller class for managing tickets.
 *
 * @author Kolesnikov Vladislav
 */
@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final ITicketService service;

    /**
     * Constructor.
     */
    public TicketController(ITicketService service) {
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
    public TicketGetDto create(@RequestBody TicketCreateDto createDto) {
        return service.create(createDto);
    }

    /**
     * Updates the ticket by id.
     *
     * @param id        identifier used to find existing ticket
     * @param updateDto DTO that holds information about new entity
     * @return Dto from updated entity or null
     */
    @PutMapping(path = "/{id}")
    public TicketGetDto updateById(@PathVariable int id,
                                   @RequestBody TicketUpdateDto updateDto) {
        return service.updateById(id, updateDto);
    }

    /**
     * Deletes the ticket by id.
     *
     * @param id identifier used to find existing ticket
     */
    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }

    /**
     * Fetches instance of {@link TicketGetDto} by id.
     *
     * @param id for search by id
     */
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public TicketGetDto getById(@PathVariable("id") int id) {
        return service.getById(id);
    }

    /**
     * Fetches a list of {@link TicketGetDto} instances.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TicketGetDto> getAll() {
        return service.getAll();
    }
}
