package com.example.dinnerknight.repositories;

import com.example.dinnerknight.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    Event findEventById(long id);
    Event findEventByName(String name);
    Event findEventByAddress(String address);
    Event findEventByDescription(String description);

}
