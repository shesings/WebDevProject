package main.java.com.example.cs450020su1ssinghprojectserverjava.services;

import com.example.cs450020su1ssinghprojectserverjava.models.Profile;
import main.java.com.example.cs450020su1ssinghprojectserverjava.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository repository;

    public Profile createProfile(Profile profile) {
        return repository.save(profile);
    }

    public Profile findProfileByUserId(Integer uid) {
        System.out.println("finding profile");
        return repository.findProfileByUserId(uid);
    }

    public Profile updateProfile(Profile updateProfile) {
        Profile profile1 = repository.findProfileById(updateProfile.getId());
        if (profile1 == null) {
            return createProfile(updateProfile);
        }
        profile1.setAbout(updateProfile.getAbout());
        profile1.setEmail(updateProfile.getEmail());
        profile1.setGender(updateProfile.getGender());
        profile1.setName(updateProfile.getName());
        profile1.setTimeSpentOnAnime(updateProfile.getTimeSpentOnAnime());
        return repository.save(profile1);
    }
}