package top.example.img.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import top.example.img.auth.repository.UserRepository;
import org.springframework.stereotype.Service;
import top.example.img.auth.model.User;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    public void UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void save(User user) {
        User userFromDB = userRepository.findByEmail(user.getEmail());

        if (userFromDB != null) {
            return;
        }
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        //user.setRoles(new HashSet<>(roleRepository.findAll()));
//        user.setRoles(Collections.singleton(new Role(2L, "ROLE_USER")));
//        user.setCreatedOn(new Date());
        userRepository.save(user);
    }

    public User findByLogin(String login) {
        return userRepository.findByEmail(login);
    }

    public User findByLoginAndPassword(String login, String password) {
//        User userEntity = findByLogin(login);
//        if (userEntity != null) {
//            if (passwordEncoder.matches(password, userEntity.getPassword())) {
//                return userEntity;
//            }
//        }
        return null;
    }

}
