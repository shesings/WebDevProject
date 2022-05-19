package main.java.com.example.cs450020su1ssinghprojectserverjava.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private Timestamp timestamp;
    private String reaction;
    private String name;
    private String animeId;


    public Review() {
    }

    public Review(Integer userId, Timestamp timestamp, String reaction, String name, String animeId) {
        this.userId = userId;
        this.timestamp = timestamp;
        this.reaction = reaction;
        this.name = name;
        this.animeId = animeId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimeId() {
        return animeId;
    }

    public void setAnimeId(String animeId) {
        this.animeId = animeId;
    }
}
