package it.unicam.cs.ids.loyaltyplatform.service;


import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Review;
import it.unicam.cs.ids.loyaltyplatform.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void addReview(Review review) {

        this.reviewRepository.save(review);
    }

    public void deleteReviewById(Integer id) {
        if(reviewRepository.findById(id).isPresent()) {
            throw new EntityNotFoundException("The id(" + id + ") of the review to delete does not exist");
        }
        this.reviewRepository.deleteById(id);
    }

    public void updateReview(Integer id, Review review) {
        Review r = getReviewById(id);
        r.setText(review.getText());
        this.reviewRepository.saveAndFlush(r);
    }

    public Review getReviewById(Integer id) {
        return this.reviewRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The id(" + id + ") of the review does not exist"));
    }

    public List<Review> getReviewByIdCustomer(Integer idCustomer) {
        return this.reviewRepository.findByIdCustomer(idCustomer);

    }

    public List<Review> getReviewByIdAgency(Integer idAgency) {
        return this.reviewRepository.findByIdAgency(idAgency);
    }

    public List<Review> getReviewByIdCustomerAndIdAgency(Integer idCustomer, Integer idAgency) {
        return this.reviewRepository.findByIdCustomerAndIdAgency(idCustomer, idAgency);
    }

    public List<Review> getAllReviews() {return this.reviewRepository.findAll();
    }
}