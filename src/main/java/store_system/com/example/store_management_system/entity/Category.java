package store_system.com.example.store_management_system.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;

@Entity
@Data
@Builder
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String createAt;
    private String createBy;
    @Nullable
    private String updateAt;
    @Nullable
    private String updateBy;
}
