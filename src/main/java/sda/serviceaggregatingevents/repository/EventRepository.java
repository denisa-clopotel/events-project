package sda.serviceaggregatingevents.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sda.serviceaggregatingevents.entity.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByUsers_Id(Long userId);

}
