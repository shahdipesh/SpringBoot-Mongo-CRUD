package com.example.demo.Services;

import com.example.demo.Entity.Review;

import com.example.demo.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public List<Review> getAllReviews(){
        return  reviewRepository.findAll();
    }
    public Review addReview(Review review){
        return  reviewRepository.save(review);
    }

    public  Review findReviewById(String id){
      List<Review> allReviews = getAllReviews();
      for(Review review: allReviews){
          if(review.getId().equals(id)){

              return review;
          }
      }
      return null;
    }

    public void deleteReviewById(String id){

        reviewRepository.deleteById(id);
    }

    public  Review updateReviewById(String id, Review newReview){
        List<Review> allReviews = getAllReviews();
        for(Review review: allReviews){
            if(review.getId().equals(id)){
                review.setBody(newReview.getBody());
                review.setSrc(newReview.getSrc());
                review.setTitle(newReview.getTitle());
                reviewRepository.save(review);
            }
        }
        return null;
    }

}
