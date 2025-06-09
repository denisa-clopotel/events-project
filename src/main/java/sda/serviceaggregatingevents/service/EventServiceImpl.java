package sda.serviceaggregatingevents.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sda.serviceaggregatingevents.DTO.EventRequest;
import sda.serviceaggregatingevents.DTO.EventResponse;
import sda.serviceaggregatingevents.entity.Event;
import sda.serviceaggregatingevents.entity.User;
import sda.serviceaggregatingevents.repository.EventRepository;
import sda.serviceaggregatingevents.repository.UserRepository;
import sda.serviceaggregatingevents.exceptions.error.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Override
    public void createEvent(EventRequest request) {
        List<User> users = userRepository.findAllById(request.getUserIds());

        if (users.isEmpty()) {
            throw new RuntimeException("No users found for given IDs.");
        }

        Event event = new Event();
        event.setTitle(request.getTitle());
        event.setStartTime(request.getStartTime());
        event.setEndTime(request.getEndTime());
        event.setDescription(request.getDescription());
        event.setUsers(users);

        eventRepository.save(event);
    }

    @Override
    public EventResponse getEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        List<String> userNames = event.getUsers().stream()
                .map(User::getName)
                .collect(Collectors.toList());

        return new EventResponse(
                event.getId(),
                event.getTitle(),
                event.getStartTime(),
                event.getEndTime(),
                event.getDescription(),
                userNames
        );
    }

    @Override
    public List<EventResponse> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(event -> new EventResponse(
                        event.getId(),
                        event.getTitle(),
                        event.getStartTime(),
                        event.getEndTime(),
                        event.getDescription(),
                        event.getUsers().stream()
                                .map(User::getName)
                                .collect(Collectors.toList())
                )).collect(Collectors.toList());
    }

    @Override
    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event with id " + id + " not found"));

        event.getUsers().clear();
        eventRepository.save(event);

        eventRepository.deleteById(id);
    }

}
