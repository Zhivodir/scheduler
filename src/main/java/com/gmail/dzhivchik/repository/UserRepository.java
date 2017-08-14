package com.gmail.dzhivchik.repository;

import com.gmail.dzhivchik.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by User on 09.08.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u from User u where u.login = :login")
    User findByLogin(@Param("login") String login);
}
