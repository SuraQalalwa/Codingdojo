package com.bookclub.mvc.sercvises;

import java.util.Optional;

import com.bookclub.mvc.models.LoginUser;
import com.bookclub.mvc.models.User;
import com.bookclub.mvc.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
        if (potentialUser.isPresent()){
            result.rejectValue("email", "Matches", "Email is already existed!");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if (result.hasErrors()){
            return null;
        }
        else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            userRepo.save(newUser);
            return newUser;
        }
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
        if (result.hasErrors()) {
            return null;
        }
        Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
        if (!potentialUser.isPresent()) {
            result.rejectValue("email", "Matches", "this Email is not registered!");
        }
        User user= potentialUser.get();
        if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }

        return user;
    }

    public User findById(Long id){
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()){
            return user.get();
        }
        return null;
    }
    public User allUsers(){
        return (User) userRepo.findAll();
    }
}
