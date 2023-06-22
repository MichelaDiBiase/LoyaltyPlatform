package it.unicam.cs.ids.loyaltyplatform.service;


import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Review;
import it.unicam.cs.ids.loyaltyplatform.repository.ReviewRepository;
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

    public void deleteReview(Review review) {

        this.reviewRepository.delete(review);
    }

    public void updateReview(Review review) {
        this.reviewRepository.saveAndFlush(review);
    }

    public List<Review> getReviewByCustomerId(Integer idCustomer) {
        return this.reviewRepository.findAll().parallelStream().filter(x -> x.getIdCostumer() == (idCustomer)).toList();

    }

    public List<Review> getReviewByAgencyId(Integer idAgency) {
        return this.reviewRepository.findAll().parallelStream().filter(x -> x.getIdAgency() == (idAgency)).toList();
    }

    public List<Review> getReviewByCustomerIdAndAgencyId(Integer idCustomer, Integer idAgency) {
        return this.reviewRepository.findAll().parallelStream().filter(x -> x.getIdCostumer() == idCustomer && x.getIdAgency() == idAgency).toList();
    }


}
