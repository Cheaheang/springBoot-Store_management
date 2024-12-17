package store_system.com.example.store_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store_system.com.example.store_management_system.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
