package com.gmail.dzhivchik.dao;

import com.gmail.dzhivchik.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 09.08.2017.
 */
public interface UserDAO  extends JpaRepository<User, Long> {
}
