package sda.serviceaggregatingevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.serviceaggregatingevents.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByEventId(Long eventId);

    List<Comment> findByUserId(Long userId);
}
