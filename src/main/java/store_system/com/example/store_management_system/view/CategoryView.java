package store_system.com.example.store_management_system.view;

import lombok.Builder;
import lombok.Data;
import store_system.com.example.store_management_system.entity.Category;

//@Data
@Builder
public class CategoryView {
    private Long id;
    private String name;
    private String createAt;
    private String createBy;
    private String updateAt;
    private String updateBy;

    public static CategoryView of(Category category) {
        return CategoryView.builder()
                .name(category.getName())
                .createAt(category.getCreateAt())
                .createBy(category.getCreateBy())
                .updateAt(category.getUpdateAt())
                .updateBy(category.getUpdateBy())
                .build();
    }
}
