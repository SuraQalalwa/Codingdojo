package com.loginandregistration.mvc.servecies;

import java.util.Optional;

import com.loginandregistration.mvc.models.LoginUser;
import com.loginandregistration.mvc.models.User;
import com.loginandregistration.mvc.repositories.UserRepository;
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
        if (potentialUser.isPresent()) {
            result.rejectValue("email", "Matches", "Email is already exist!");
        }
        if (!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if (result.hasErrors()) {
            return null;
        } else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            userRepo.save(newUser);
            return newUser;

        }

// TO-DO - Reject values or register if no errors:

        // Reject if email is taken (present in database)
        // Reject if password doesn't match confirmation

        // Return null if result has errors

        // Hash and set password, save user to database
        // TO-DO: Additional validations!
    }

    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
        Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
        if (!potentialUser.isPresent()) {
            result.rejectValue("email", "Matches", "this Email is not registered!");
        }
        User user = potentialUser.get();
        String hashed = BCrypt.hashpw(newLoginObject.getPassword(), BCrypt.gensalt());
        if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if (result.hasErrors()) {
            return null;


        }
       return user;

    }

    public User findById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

}
