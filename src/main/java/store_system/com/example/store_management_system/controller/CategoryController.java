package store_system.com.example.store_management_system.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store_system.com.example.store_management_system.entity.Category;
import store_system.com.example.store_management_system.form.CreateCategoryForm;
import store_system.com.example.store_management_system.form.UpdateCategoryForm;
import store_system.com.example.store_management_system.service.CategoryService;
import store_system.com.example.store_management_system.view.CategoryView;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryView> getCategory(){
        return categoryService.getCategory();
    }
    @PostMapping
    public CategoryView createCategory(@RequestBody CreateCategoryForm form){
        return categoryService.createCategory(form);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody UpdateCategoryForm form){
        String result = categoryService.updateCategory(form, id);
        if(result.equals("Update failed")){
            return ResponseEntity.status(404).body(result);
        }
        return ResponseEntity.status(200).body(result) ;
    }
}
