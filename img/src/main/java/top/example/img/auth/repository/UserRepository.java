package top.example.img.auth.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import top.example.img.auth.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
