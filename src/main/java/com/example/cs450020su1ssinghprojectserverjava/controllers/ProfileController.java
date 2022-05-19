package main.java.com.example.cs450020su1ssinghprojectserverjava.controllers;

import com.example.cs450020su1ssinghprojectserverjava.models.Profile;
import com.example.cs450020su1ssinghprojectserverjava.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/profile")
    public Profile getProfile(@RequestParam int uid) {
        return profileService.findProfileByUserId(uid);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public Profile getProfile(@RequestBody Profile profile) {
        System.out.println(profile.getUserId());
        return profileService.findProfileByUserId(profile.getUserId());
    }


    @PutMapping("/profile")
    public Profile updateProfile(@RequestBody Profile updateProfile) {
        return profileService.updateProfile(updateProfile);
    }

}
