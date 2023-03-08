package com.example.dinnerknight.repositories;

import com.example.dinnerknight.models.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackRepository extends JpaRepository<Pack, Long> {
    Pack findPackById(long id);
    Pack findPackByName(String name);
    Pack findPackByAddress(String address);
    Pack findPackByCook_id(long id);
    Pack findPackByDescription(String description);
}
