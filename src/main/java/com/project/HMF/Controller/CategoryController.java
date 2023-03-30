package com.project.HMF.Controller;

import com.project.HMF.Dto.res.CategoryResDto;
import com.project.HMF.Model.CategoryMaster;
import com.project.HMF.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    private ResponseEntity create(@RequestBody CategoryMaster categoryMaster) {
        CategoryResDto categoryResDto = categoryService.categoryCreate(categoryMaster);
        if (categoryResDto != null) {
            return new ResponseEntity(categoryResDto, HttpStatus.OK);
        } else {
            return new ResponseEntity(categoryResDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    private ResponseEntity categoryUpdate(@RequestBody CategoryMaster categoryMaster) {
        boolean flag = categoryService.categoryUpdate(categoryMaster);
        if (flag) {
            return new ResponseEntity(flag, HttpStatus.OK);
        } else {
            return new ResponseEntity(flag, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    private ResponseEntity getAllCategory() {
        List list = categoryService.getAllCategory();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "/getById/{categoryId}")
    private ResponseEntity getCategoryById(@PathVariable Integer categoryId) {
        CategoryMaster categoryMaster = categoryService.getCategoryById(categoryId);
        if (categoryMaster != null) {
            return new ResponseEntity(categoryMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity(categoryMaster, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/activeCategory")
    private ResponseEntity activeCategory() {
        List list = categoryService.activeCategory();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
