package com.omers.omer.s.Repository;

import com.omers.omer.s.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query ("SELECT r FROM Review r WHERE r.rating = :rating")
    List<Review> findByRating(Double rating);
}
