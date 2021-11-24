package com.antra.validationwithuserapi.Repository;

import com.antra.validationwithuserapi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByFirstName(String firstName);
}
