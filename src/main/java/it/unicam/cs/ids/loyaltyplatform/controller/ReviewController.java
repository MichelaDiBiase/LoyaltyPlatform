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

    @DeleteMapping(value = "/deleteReview")
    public void deleteReview(@RequestBody Review review) {

        this.reviewService.deleteReview(review);
    }
    @PutMapping(value = "/updateReview/{id}")
    public void updateReview(@PathVariable Integer id, @RequestBody Review review) {

        this.reviewService.updateReview(id, review);
    }
    @GetMapping(value = "/getReviewByCustomerId/{idCustomer}")
    public List<Review> getReviewByCustomerId(@PathVariable Integer idCustomer) {
        return this.reviewService.getReviewByCustomerId(idCustomer);
    }

    @GetMapping(value = "/getReviewByAgencyId/{idAgency}")
    public List<Review> getReviewByAgencyId(@PathVariable Integer idAgency) {
        return this.reviewService.getReviewByAgencyId(idAgency);
    }

    @GetMapping(value = "/getReviewByCustomerIdAndAgencyId/{idCustomer}&{idAgency}")
    public List<Review> getReviewByCustomerIdAndAgencyId(@PathVariable Integer idCustomer, @PathVariable Integer idAgency) {
        return this.reviewService.getReviewByCustomerIdAndAgencyId(idCustomer,idAgency);
    }

    @GetMapping(value = "/getAllReviews")
    public List<Review> getAllReviews() { return this.reviewService.getAllReviews();    }
}
