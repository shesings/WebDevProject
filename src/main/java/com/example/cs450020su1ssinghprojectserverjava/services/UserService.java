package main.java.com.example.cs450020su1ssinghprojectserverjava.services;

import com.example.cs450020su1ssinghprojectserverjava.models.User;
import main.java.com.example.cs450020su1ssinghprojectserverjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    List<User> tempUsers = new LinkedList<>();

    {
//        tempUsers.add(new User(123, "User 1", "HEADING", "111"));
//        tempUsers.add(new User(234, "User 2", "PARAGRAPH", "111"));
//        tempUsers.add(new User(345, "User 3", "YOUTUBE", "111"));
//        tempUsers.add(new User(432, "User 4", "IMAGE", "111"));
//        tempUsers.add(new User(567, "User 5", "PARAGRAPH", "1111"));
    }

    @Autowired
    UserRepository repository;

    public User createUser(User user) {
        return repository.save(user);
    }

    public User findUserById(Integer id) {
        return repository.findUserById(id);
    }

    public User findUserByCredentials(String username, String password) {
        return repository.findUserByCredentials(username, password);
    }

    public User findUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }


}
