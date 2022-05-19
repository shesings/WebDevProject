package main.java.com.example.cs450020su1ssinghprojectserverjava.repository;

import com.example.cs450020su1ssinghprojectserverjava.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository
        extends CrudRepository<Review, Integer> {

    @Query("SELECT review FROM Review review WHERE review.userId=:uid")
    public List<Review> findReviewsByUserId(@Param("uid") Integer userId);

    @Query("SELECT review FROM Review review WHERE review.animeId=:aid")
    public List<Review> findReviewsByAnimeId(@Param("aid") String animeId);

}