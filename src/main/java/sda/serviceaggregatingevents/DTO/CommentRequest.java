package sda.serviceaggregatingevents.DTO;

import lombok.Data;

@Data
public class CommentRequest {
    private String comment;
    private Long userId;
    private Long eventId;
}
