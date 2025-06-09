package sda.serviceaggregatingevents.service;


import sda.serviceaggregatingevents.DTO.CommentRequest;
import sda.serviceaggregatingevents.DTO.CommentResponse;


import java.util.List;


public interface CommentService {
    void addComment(CommentRequest request);
    List<CommentResponse> getCommentsForEvent(Long eventId);
}

