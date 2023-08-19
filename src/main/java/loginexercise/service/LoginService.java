package loginexercise.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import loginexercise.entity.User;
import loginexercise.repository.UserRepository;

public class LoginService {
    private UserRepository userRepository = new UserRepository();

    public User checkLogin(HttpServletRequest req,String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        
        if (user != null) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("userLoggedIn", user);
        }

        return user;
    }
}
