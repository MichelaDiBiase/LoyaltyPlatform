package it.unicam.cs.ids.loyaltyplatform.controller;



import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Review;
import it.unicam.cs.ids.loyaltyplatform.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @PostMapping(value = "/addReview")
    public void addReview(@RequestBody Review review) {

        this.reviewService.addReview(review);
    }

    @DeleteMapping(value = "/deleteReviewById/{id}")
    public void deleteReviewById(@PathVariable Integer id) {

        this.reviewService.deleteReviewById(id);
    }
    @PutMapping(value = "/updateReview/{id}")
    public void updateReview(@PathVariable Integer id, @RequestBody Review review) {

        this.reviewService.updateReview(id, review);
    }

    @GetMapping(value = "/getReviewById/{id}")
    public Review getReviewById(@PathVariable Integer id) {
        return this.reviewService.getReviewById(id);
    }

    @GetMapping(value = "/getReviewByIdCustomer/{idCustomer}")
    public List<Review> getReviewByIdCustomer(@PathVariable Integer idCustomer) {
        return this.reviewService.getReviewByIdCustomer(idCustomer);
    }

    @GetMapping(value = "/getReviewByIdAgency/{idAgency}")
    public List<Review> getReviewByIdAgency(@PathVariable Integer idAgency) {
        return this.reviewService.getReviewByIdAgency(idAgency);
    }

    @GetMapping(value = "/getReviewByIdCustomerAndIdAgency/{idCustomer}&{idAgency}")
    public List<Review> getReviewByIdCustomerAndIdAgency(@PathVariable Integer idCustomer, @PathVariable Integer idAgency) {
        return this.reviewService.getReviewByIdCustomerAndIdAgency(idCustomer,idAgency);
    }

    @GetMapping(value = "/getAllReviews")
    public List<Review> getAllReviews() { return this.reviewService.getAllReviews();    }
}