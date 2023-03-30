package com.project.HMF.Service.impl;

import com.project.HMF.Dao.BannerDao;
import com.project.HMF.Dao.CategoryDao;
import com.project.HMF.Dto.res.CategoryResDto;
import com.project.HMF.Model.BannerMaster;
import com.project.HMF.Model.CategoryMaster;
import com.project.HMF.Model.UserMaster;
import com.project.HMF.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

//    @Override
//    public boolean categoryCreate(CategoryMaster categoryMaster) {
//        CategoryMaster categoryMaster1 = categoryDao.findOneByCategoryName(categoryMaster.getCategoryName());
//        if(categoryMaster1 == null) {
//        try {
//            categoryDao.save(categoryMaster);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        }
//    }


    @Override
    public CategoryResDto categoryCreate(CategoryMaster categoryMaster) {
        CategoryResDto categoryResDto = new CategoryResDto();
        CategoryMaster categoryMaster1 = categoryDao.findOneByCategoryName(categoryMaster.getCategoryName());
        if(categoryMaster1 == null) {
        try {
            categoryDao.save(categoryMaster);
            categoryResDto.setResponseCode(HttpStatus.OK.value());
            categoryResDto.setMessage("Created succesfully");
        } catch (Exception e) {
            e.printStackTrace();
            categoryResDto.setMessage("Failed");
        }
        } else {
            categoryResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            categoryResDto.setMessage("Already Exist");
        }
        return categoryResDto;
    }

    @Override
    public boolean categoryUpdate(CategoryMaster categoryMaster) {
        try {
            categoryDao.save(categoryMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getAllCategory() {
        return (List) categoryDao.findAll();
    }

    @Override
    public CategoryMaster getCategoryById(Integer categoryId) {
        CategoryMaster categoryMaster = new CategoryMaster();
        try {
            categoryMaster = categoryDao.findOne(categoryId);
            return categoryMaster;
        } catch (Exception e) {
            e.printStackTrace();
            return categoryMaster;
        }
    }

    @Override
    public List activeCategory() {
        List list = categoryDao.findAllByStatus("Active");
        return list;
    }
}
