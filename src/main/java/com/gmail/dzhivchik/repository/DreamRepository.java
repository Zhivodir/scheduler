package com.gmail.dzhivchik.repository;

import com.gmail.dzhivchik.domain.Dream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by User on 20.09.2017.
 */
public interface DreamRepository extends JpaRepository<Dream, Long> {
    @Query("SELECT d from Dream d where d.user.login = :login")
    List<Dream> findByLogin(@Param("login") String login);
}
