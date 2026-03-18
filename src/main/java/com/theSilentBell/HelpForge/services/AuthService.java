package com.theSilentBell.HelpForge.services;

import com.theSilentBell.HelpForge.db.dao.iface.IAuthRepository;
import com.theSilentBell.HelpForge.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private IAuthRepository authRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Boolean userSignUp(User user) {
        if (authRepository.findByUsername(user.getUsername()).isPresent()) {
            return false;
        }

        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        authRepository.save(user);
        return true;
    }

    public Boolean UserLogin(User user) {

        Optional<User> userOpt = authRepository.findByUsername(user.getUsername());

        if (userOpt.isPresent()) {
            User dbUser = userOpt.get();

            if (encoder.matches(user.getPassword(), dbUser.getPassword())) {
                // TODO: generate JWT
                return true;
            }
        }

        return false;
    }
}
