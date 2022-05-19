package main.java.com.example.cs450020su1ssinghprojectserverjava.repository;

import com.example.cs450020su1ssinghprojectserverjava.models.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProfileRepository
        extends CrudRepository<Profile, Integer> {
    @Query("SELECT profile FROM Profile profile WHERE profile.userId=:uid")
    public Profile findProfileByUserId(@Param("uid") Integer userId);

    @Query("SELECT p FROM Profile p WHERE p.id=:pid")
    public Profile findProfileById(@Param("pid") Integer profileId);

}