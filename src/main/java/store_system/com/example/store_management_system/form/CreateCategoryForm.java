package store_system.com.example.store_management_system.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import store_system.com.example.store_management_system.entity.Category;

import java.time.LocalDate;



@RequiredArgsConstructor
public class CreateCategoryForm {
    @NotBlank
    private String name;
    @NotBlank
    private String createAt;
    @NotBlank
    private String createBy;
    private String updateAt;
    private String updateBy;
    public Category toCategory(){
        return Category.builder()
                .name(name)
                .createBy(createBy)
                .updateBy(updateBy)
                .createAt( LocalDate.now().toString())
                .updateAt(updateAt)
                .updateBy(updateBy)
                .build();
    }
}
