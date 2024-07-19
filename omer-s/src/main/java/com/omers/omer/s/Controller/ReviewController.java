package com.omers.omer.s.Controller;

import com.omers.omer.s.Model.Review;
import com.omers.omer.s.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    //http://localhost:8081/review/getall
    @GetMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Review>> getAll() {
        try {
            List<Review> reviews = reviewService.getAllReviews();
            return ResponseEntity.ok(reviews);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8081/review/getbyid/{id}
    @GetMapping(path = "/getbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Review> getById(@PathVariable(name = "id") Integer id) {
        try {
            Optional<Review> review = reviewService.getById(id);
            return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //getReviewsByRating
    //http://localhost:8081/review/getbyrating/{rating}
    @GetMapping(path = "/getbyrating/{rating}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Review>> getReviewsByRating(@PathVariable(name = "rating") Double rating) {
        try {
            List<Review> reviews = reviewService.getReviewsByRating(rating);
            return ResponseEntity.ok(reviews);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8081/review/save
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Review> save(@RequestBody Review review) {
        try {
            Review savedReview = reviewService.saveReview(review);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedReview);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8081/review/delete/{id}
    @DeleteMapping(path = "/delete/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> delete(@PathVariable(name = "id") Integer id) {
        try {
            boolean result = reviewService.deleteReview(id);
            if (result) {
                return ResponseEntity.ok(id + " id'li yorum başarı ile silindi");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " id'li yorum bulunamadı");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(id + " id'li yorum silinemedi");
        }
    }
}
