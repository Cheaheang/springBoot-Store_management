package store_system.com.example.store_management_system.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "categories")
@RequiredArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String createAt;
    private String createBy;
    private String updateAt;
    private String updateBy;
}
