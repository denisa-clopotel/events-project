package sda.serviceaggregatingevents.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.serviceaggregatingevents.DTO.CommentRequest;
import sda.serviceaggregatingevents.DTO.CommentResponse;
import sda.serviceaggregatingevents.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Void> addComment(@RequestBody CommentRequest request) {
        commentService.addComment(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/event/{eventId}")
    public List<CommentResponse> getCommentsForEvent(@PathVariable Long eventId) {
        return commentService.getCommentsForEvent(eventId);
    }
}

