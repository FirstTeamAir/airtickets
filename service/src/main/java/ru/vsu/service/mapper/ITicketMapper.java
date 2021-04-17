package ru.vsu.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Qualifier;
import ru.vsu.repository.entity.Airline;
import ru.vsu.repository.entity.Ticket;
import ru.vsu.repository.entity.TravelClass;
import ru.vsu.service.model.create.TicketCreateDto;
import ru.vsu.service.model.get.TicketGetDto;
import ru.vsu.service.model.update.TicketUpdateDto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/**
 * Maps between {@link Ticket} and it's DTOs.
 *
 * @author Kolesnikov Vladislav
 */
@Mapper
public interface ITicketMapper {

    /**
     * Maps travel class.
     *
     * @param travelClassId {@link TravelClass} id
     * @return {@link TravelClass} with id = travelClassId
     */
    @GetTravelClassFromId
    default TravelClass mapType(Integer travelClassId) {
        return TravelClass.fromId(travelClassId);
    }

    /**
     * Maps ticket airline id.
     */
    @GetAirlineFromId
    default Airline poolFromId(Integer id) {
        if (id == null) {
            return null;
        }
        final var airline = new Airline();
        airline.setId(id);
        return airline;
    }

    /**
     * Converts {@link TicketCreateDto} to {@link Ticket}.
     *
     * @param dto DTO to convert
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "airline", source = "airlineId", qualifiedBy = GetAirlineFromId.class)
    @Mapping(target = "travelClass", source = "travelClassId", qualifiedBy = GetTravelClassFromId.class)
    Ticket fromCreateDto(TicketCreateDto dto);

    /**
     * Converts {@link Ticket} to {@link TicketGetDto}.
     *
     * @param entity entity to convert
     */
    TicketGetDto toGetDto(Ticket entity);

    /**
     * Converts list of {@link Ticket} to list of {@link TicketGetDto}.
     *
     * @param entity entity to convert
     */
    List<TicketGetDto> toGetDto(List<Ticket> entity);

    /**
     * Converts {@link TicketCreateDto} to {@link Ticket}
     * and update ticket.
     *
     * @param dto    DTO to convert
     * @param ticket Ticket to update
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "airline", source = "airlineId", qualifiedBy = GetAirlineFromId.class)
    @Mapping(target = "travelClass", source = "travelClassId", qualifiedBy = GetTravelClassFromId.class)
    void mergeUpdate(TicketUpdateDto dto, @MappingTarget Ticket ticket);

    @Qualifier
    @Retention(RetentionPolicy.CLASS)
    @Target(ElementType.METHOD)
    @interface GetTravelClassFromId {}

    @Qualifier
    @Retention(RetentionPolicy.CLASS)
    @Target(ElementType.METHOD)
    @interface GetAirlineFromId {}
}
