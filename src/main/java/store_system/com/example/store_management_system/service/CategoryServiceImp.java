package store_system.com.example.store_management_system.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store_system.com.example.store_management_system.form.CreateCategoryForm;
import store_system.com.example.store_management_system.form.UpdateCategoryForm;
import store_system.com.example.store_management_system.repository.CategoryRepository;
import store_system.com.example.store_management_system.view.CategoryView;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImp implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryView> getCategory() {
        return categoryRepository.findAll().stream().map(CategoryView::of).toList();
    }

    @Override
    public CategoryView createCategory(CreateCategoryForm form) {
        return CategoryView.of(categoryRepository.saveAndFlush(form.toCategory()));
    }

    @Override
    public String updateCategory(UpdateCategoryForm form, Long id) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(form.getName());
            category.setUpdateAt(form.getUpdateAt());
            return "Update successfully";
        }).orElse("Update failed");
    }

    @Override
    public String deleteCategory(Long id) {
        return null;
    }
}
