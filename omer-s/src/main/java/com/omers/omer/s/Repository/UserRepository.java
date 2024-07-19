package com.omers.omer.s.Repository;

import com.omers.omer.s.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.username = :username")
    List<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    public List<User> findByEmail(String email);
}
