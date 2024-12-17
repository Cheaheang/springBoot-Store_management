package store_system.com.example.store_management_system.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "products")
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String categoryId;
    private String cost;
    private String price;
    private String qty;
    private String createAt;
    private String createBy;
    private String updateAt;
    private String updateBy;

}
