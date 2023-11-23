package uz.yangaliev.userservice.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.yangaliev.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
