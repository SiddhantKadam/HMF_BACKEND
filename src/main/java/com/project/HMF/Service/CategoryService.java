package com.project.HMF.Service;

import com.project.HMF.Dto.res.CategoryResDto;
import com.project.HMF.Model.CategoryMaster;

import java.util.List;

public interface CategoryService {
    CategoryResDto categoryCreate(CategoryMaster categoryMaster);

    boolean categoryUpdate(CategoryMaster categoryMaster);

    List getAllCategory();

    CategoryMaster getCategoryById(Integer categoryId);

    List activeCategory();

}
