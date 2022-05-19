package main.java.com.example.cs450020su1ssinghprojectserverjava.services;

import com.example.cs450020su1ssinghprojectserverjava.models.Profile;
import com.example.cs450020su1ssinghprojectserverjava.models.Review;
import com.example.cs450020su1ssinghprojectserverjava.models.User;
import main.java.com.example.cs450020su1ssinghprojectserverjava.repository.ProfileRepository;
import main.java.com.example.cs450020su1ssinghprojectserverjava.repository.ReviewRepository;
import main.java.com.example.cs450020su1ssinghprojectserverjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository repository;

    @Autowired
    UserRepository userRepository;

    public Review createReview(Review review) {
        User user = userRepository.findUserById(review.getUserId());
        review.setName(user.getUsername());
        return repository.save(review);
    }

    public List<Review> findReviewsForUser(Integer uid) {
        return repository.findReviewsByUserId(uid);
    }

    public List<Review> findReviewsByAnimeId(String aid) {
        return repository.findReviewsByAnimeId(aid);
    }

    public List<Review> findAllReviews() {
        List<Review> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public void deleteReviewById(int rid) {
         repository.deleteById(rid);
    }
}