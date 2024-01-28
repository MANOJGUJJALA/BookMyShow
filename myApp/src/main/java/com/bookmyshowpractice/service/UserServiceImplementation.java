package service;

import exception.InvalidCredentials;
import exception.UserAlreadyExists;
import repository.UserRepository;
import exception.UserNotFoundException;
import modals.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User login(String email, String password) {
        Optional<User>optionalUser=userRepository.findByEmail(email);

        if(optionalUser.isEmpty()){

            throw new UserNotFoundException("User Not Found");
        }
        User user=optionalUser.get();
        if(user.getPassword().equals(password)){
            return user;
        }
        else {
            throw new InvalidCredentials("credentila wrong");
        }
//        return user;
    }

    @Override
    public User signUp(String name, String email, String password) {

        Optional<User>optionalUser=userRepository.findByEmail(email);

        if(optionalUser.isPresent()){
            throw new UserAlreadyExists("user alreday exists");
        }

        User user=new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);


        return userRepository.save(user);
    }
}
