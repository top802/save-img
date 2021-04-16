package top.example.img.auth.service;

import top.example.img.auth.model.User;

public interface UserService {
    User findByEmail(String email);
}
