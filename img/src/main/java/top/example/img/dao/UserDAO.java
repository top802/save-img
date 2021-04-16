package top.example.img.dao;

import org.springframework.data.repository.CrudRepository;
import top.example.img.model.User;

public interface UserDAO extends CrudRepository<User, Long> {
}
