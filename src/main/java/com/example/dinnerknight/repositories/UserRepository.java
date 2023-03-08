package com.example.dinnerknight.repositories;

import com.example.dinnerknight.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
    User findUserById(long id);

    User findUserByUsername(String username);
    User findUserByEmail(String email);
    User findUserByFirst_name(String first_name);
    User findUserByLast_name(String last_name);
    User findUserByCook(Boolean isCook);
}
