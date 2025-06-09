package sda.serviceaggregatingevents.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sda.serviceaggregatingevents.DTO.CommentRequest;
import sda.serviceaggregatingevents.DTO.CommentResponse;
import sda.serviceaggregatingevents.entity.Comment;
import sda.serviceaggregatingevents.entity.Event;
import sda.serviceaggregatingevents.entity.User;
import sda.serviceaggregatingevents.repository.CommentRepository;
import sda.serviceaggregatingevents.repository.EventRepository;
import sda.serviceaggregatingevents.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Override
    public void addComment(CommentRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Event event = eventRepository.findById(request.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Comment comment = new Comment();
        comment.setComment(request.getComment());
        comment.setUser(user);
        comment.setEvent(event);

        commentRepository.save(comment);
    }

    @Override
    public List<CommentResponse> getCommentsForEvent(Long eventId) {
        return commentRepository.findByEventId(eventId).stream()
                .map(comment -> new CommentResponse(
                        comment.getId(),
                        comment.getComment(),
                        comment.getUser().getName(),
                        comment.getEvent().getTitle()
                ))
                .collect(Collectors.toList());
    }
}
