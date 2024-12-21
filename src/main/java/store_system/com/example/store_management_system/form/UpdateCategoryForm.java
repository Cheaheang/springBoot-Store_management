package store_system.com.example.store_management_system.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import store_system.com.example.store_management_system.entity.Category;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class UpdateCategoryForm {
    @NotBlank
    private String name;
    private String createAt;
    private String createBy;
    private String updateAt;
    @NotBlank
    private String updateBy;
    public Category toCategory(){
        return Category.builder()
                .name(name)
                .updateAt(updateAt)
                .updateBy(LocalDate.now().toString())
                .build();
    }
}
