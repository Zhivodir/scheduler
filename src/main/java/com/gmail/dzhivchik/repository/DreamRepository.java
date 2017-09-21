package com.gmail.dzhivchik.repository;

import com.gmail.dzhivchik.domain.Dream;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 20.09.2017.
 */
public interface DreamRepository extends JpaRepository<Dream, Long> {
}
