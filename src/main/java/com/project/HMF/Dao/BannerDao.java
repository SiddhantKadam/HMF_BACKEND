package com.project.HMF.Dao;

import com.project.HMF.Model.BannerMaster;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BannerDao extends CrudRepository<BannerMaster,Integer> {

    List findAllByStatus(String active);

    @Query("from BannerMaster as bm where bm.status='Active' and :toDate between bm.startdDate and bm.endDate")
    List getDatewiseBanner(@Param("toDate") Date toDate);
}
