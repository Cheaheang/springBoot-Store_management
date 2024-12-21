package store_system.com.example.store_management_system.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store_system.com.example.store_management_system.form.CreateCategoryForm;
import store_system.com.example.store_management_system.form.UpdateCategoryForm;
import store_system.com.example.store_management_system.view.CategoryView;

import java.util.List;


public interface CategoryService {
    List<CategoryView> getCategory();
    CategoryView createCategory(CreateCategoryForm form);
    String updateCategory(UpdateCategoryForm form, Long id);
    String deleteCategory(Long id);
}
