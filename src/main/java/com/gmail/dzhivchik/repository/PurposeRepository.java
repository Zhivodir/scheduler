package com.gmail.dzhivchik.repository;

import com.gmail.dzhivchik.domain.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by User on 27.09.2017.
 */
public interface PurposeRepository extends JpaRepository<Purpose, Long> {
    @Query("SELECT p from Purpose p where p.user.login = :login")
    List<Purpose> findByLogin(@Param("login") String login);

    @Query("SELECT p from Purpose p where p.user.login = :login and p.id in :purpose_id")
    List<Purpose> findByLogin(@Param("login") String login, @Param("purpose_id") long[] purpose_id);
}
