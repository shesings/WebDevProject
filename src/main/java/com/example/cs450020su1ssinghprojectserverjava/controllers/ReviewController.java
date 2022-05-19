package main.java.com.example.cs450020su1ssinghprojectserverjava.controllers;

import com.example.cs450020su1ssinghprojectserverjava.models.Profile;
import com.example.cs450020su1ssinghprojectserverjava.models.Review;
import com.example.cs450020su1ssinghprojectserverjava.services.ProfileService;
import com.example.cs450020su1ssinghprojectserverjava.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    ReviewService service;

    @GetMapping("/reviews")
    public List<Review> getProfile(@RequestParam int uid) {
        return service.findReviewsForUser(uid);
    }

    @GetMapping("/allReviews")
    public List<Review> getAllReviews() {
        return service.findAllReviews();
    }

    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public Review getProfile(@RequestBody Review review) {
        review.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return service.createReview(review);
    }

    @RequestMapping(value = "/reviewsByAid", method = RequestMethod.GET)
    public List<Review> getReview(@RequestParam String aid) {
        return service.findReviewsByAnimeId(aid);
    }

    @DeleteMapping(value = "review")
    public void deleteReview(@RequestParam int rid) {
        service.deleteReviewById(rid);
    }

}
