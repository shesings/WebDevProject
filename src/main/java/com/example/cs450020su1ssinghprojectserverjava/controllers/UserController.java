package main.java.com.example.cs450020su1ssinghprojectserverjava.controllers;

import com.example.cs450020su1ssinghprojectserverjava.models.Profile;
import com.example.cs450020su1ssinghprojectserverjava.models.User;
import com.example.cs450020su1ssinghprojectserverjava.services.ProfileService;
import com.example.cs450020su1ssinghprojectserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.Base64;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    @Autowired
    UserService userService;

    @Autowired
    ProfileService profileService;

    @PostMapping("/api/register")
    public User register(
            @RequestBody User user,
            HttpSession session) {
        User existingUser = userService.findUserByUsername(user.getUsername());
        if (existingUser == null) {
            User currentUser = userService.createUser(user);
            profileService.createProfile(new Profile(user.getId(), user.getName(), "", user.getEmail(), "", 0));
            currentUser.setAccessToken(generateAccessToken());
            session.setAttribute("currentUser", currentUser);
            return currentUser;
        }
        return null;
    }

    private static String generateAccessToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    @PostMapping("/api/profile")
    public User profile(
            @RequestBody User user,
            HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        return currentUser;
    }


    @PostMapping("/api/login")
    public User login(
            @RequestBody User user,
            HttpSession session) {
        User currentUser = userService.findUserByCredentials(user.getUsername(), user.getPassword());
        currentUser.setAccessToken(generateAccessToken());
        session.setAttribute("currentUser", currentUser);
        return currentUser;
    }

    @PostMapping("/api/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }
}