package it.unicam.cs.ids.loyaltyplatform.controller;



import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Review;
import it.unicam.cs.ids.loyaltyplatform.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
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
    public void deleteReview(@PathVariable("review") Review review) {

        this.reviewService.deleteReview(review);
    }
    @PutMapping(value = "/updateReview")
    public void updateReview(@RequestBody Review review) {

        this.reviewService.updateReview(review);
    }
    @GetMapping(value = "/getReviewByCustomerId")
    public List<Review> getReviewByCustomerId(Integer idCustomer) {
        return this.reviewService.getReviewByCustomerId(idCustomer);
    }

    @GetMapping(value = "/getReviewByAgencyId")
    public List<Review> getReviewByAgencyId(Integer idAgency) {
        return this.reviewService.getReviewByAgencyId(idAgency);
    }

    @GetMapping(value = "/getReviewByCustomerIdAndAgencyId")
    public List<Review> getReviewByCustomerIdAndAgencyId(Integer idCustomer, Integer idAgency) {
        return this.reviewService.getReviewByCustomerIdAndAgencyId(idCustomer,idAgency);
    }
}
