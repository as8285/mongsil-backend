package com.nurung.mongsil.repo;

import com.nurung.mongsil.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,String> {

}
