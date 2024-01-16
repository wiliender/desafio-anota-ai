package com.wiliender.desafioanotaai.controllers;

import com.wiliender.desafioanotaai.domain.category.Category;
import com.wiliender.desafioanotaai.domain.category.CategoryDTO;
import com.wiliender.desafioanotaai.services.CategoryService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService service;

    public CategoryController(CategoryService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryData){
        Category newCategory = this.service.insert(categoryData);
        return ResponseEntity.ok().body(newCategory);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categories = this.service.getAll();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathParam("id") String id, @RequestBody CategoryDTO categoryData){
    Category updateCategory = this.service.update(id, categoryData);
    return ResponseEntity.ok().body(updateCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathParam("id") String id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
