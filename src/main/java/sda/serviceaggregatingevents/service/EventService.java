package sda.serviceaggregatingevents.service;


import sda.serviceaggregatingevents.DTO.EventRequest;
import sda.serviceaggregatingevents.DTO.EventResponse;


import java.util.List;


public interface EventService {
    void createEvent(EventRequest request);
    EventResponse getEvent(Long id);
    List<EventResponse> getAllEvents();
    void deleteEvent(Long id);
}