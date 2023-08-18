package loginexercise.service;

import loginexercise.entity.User;
import loginexercise.repository.UserRepository;

public class LoginService {
    private UserRepository userRepository = new UserRepository();

    public User checkLogin(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);

        return user;
    }
}
