package com.example.dinnerknight.repositories;

import com.example.dinnerknight.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
