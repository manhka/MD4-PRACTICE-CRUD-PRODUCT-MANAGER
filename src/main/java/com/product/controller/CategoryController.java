package com.product.controller;

import com.product.model.Category;
import com.product.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Iterable<Category>> findAllCategory() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Category> creatNewCategory(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity("CREATE SUCCESSFULLY", HttpStatus.CREATED);
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Category> findOneById(@PathVariable Long id){
//        Optional<Category> category=categoryService.findById(id);
//        if (!category.isPresent()){
//            return new ResponseEntity("don't see anything", HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(category.get(),HttpStatus.OK);
//    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Category> editCategory(@PathVariable Long id,@RequestBody Category category){

            Optional<Category> categoryOptional=categoryService.findById(id);
            if (!categoryOptional.isPresent()){
                return new ResponseEntity("DONT SEE ANYTHING", HttpStatus.NOT_FOUND);
            }
            category.setId(categoryOptional.get().getId());
            categoryService.save(category);
            return new ResponseEntity("EDIT SUCCESSFULLY",HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id){

            Optional<Category> categoryOptional=categoryService.findById(id);
            if (!categoryOptional.isPresent()){
                return new ResponseEntity("DONT SEE ANYTHING", HttpStatus.NOT_FOUND);
            }
            categoryService.remove(id);
            return new ResponseEntity("DELETE SUCCESSFULLY",HttpStatus.OK);
    }
}
