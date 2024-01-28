package service;

import modals.User;

public interface UserService {
     User login(String email, String password);
    User signUp(String name, String email, String password);
}
