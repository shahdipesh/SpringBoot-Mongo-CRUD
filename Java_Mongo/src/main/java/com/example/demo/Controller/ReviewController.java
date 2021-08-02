package com.example.demo.Controller;

import com.example.demo.Entity.Review;
import com.example.demo.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> getAllReviews(){

        return reviewService.getAllReviews();
    }

    @GetMapping("/reviews/{id}")
    public Review getReviewById(@PathVariable String id){
        return reviewService.findReviewById(id);
    }

    @PostMapping("/addReview")
    public Review addReview(@RequestBody Review review){
      return  reviewService.addReview(review);
    }

    @DeleteMapping("/deleteReview/{id}")
    public void deleteReview(@PathVariable String id) {
        reviewService.deleteReviewById(id);

    }
    @PutMapping("/updateReview/{id}")
    public Review updateReviewById(@PathVariable String id, @RequestBody Review newReview) {
        return reviewService.updateReviewById(id,newReview);
    }
}
