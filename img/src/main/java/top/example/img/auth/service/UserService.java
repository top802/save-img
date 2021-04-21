package top.example.img.auth.service;

import top.example.img.auth.model.User;

import java.util.Optional;

public interface UserService {
    User findByEmail(String email);
    User findByConfirmationToken(String confirmationToken);
    Optional<User> findUserByResetToken(String resetToken);
    void save(User user);
}
