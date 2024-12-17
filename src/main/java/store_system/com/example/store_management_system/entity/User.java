package store_system.com.example.store_management_system.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
@Builder
@Table(name = "users")
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String role;
    private String status;

}
