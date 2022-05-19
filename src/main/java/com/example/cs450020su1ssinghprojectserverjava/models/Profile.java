package main.java.com.example.cs450020su1ssinghprojectserverjava.models;

import javax.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private String name;
    private String about;
    private String email;
    private String gender;
    private Integer timeSpentOnAnime;

    public Profile() {
    }

    public Profile(Integer userId, String name, String about, String email, String gender, Integer timeSpentOnAnime) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.about = about;
        this.email = email;
        this.gender = gender;
        this.timeSpentOnAnime = timeSpentOnAnime;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getTimeSpentOnAnime() {
        return timeSpentOnAnime;
    }

    public void setTimeSpentOnAnime(Integer timeSpentOnAnime) {
        this.timeSpentOnAnime = timeSpentOnAnime;
    }
}
