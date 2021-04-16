package top.example.img.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import top.example.img.auth.repository.UserRepository;
import org.springframework.stereotype.Service;
import top.example.img.auth.model.User;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void save(User user) {

    }
}
