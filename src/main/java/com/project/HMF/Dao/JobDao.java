package com.project.HMF.Dao;

import com.project.HMF.Model.CategoryMaster;
import com.project.HMF.Model.JobMaster;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JobDao extends CrudRepository<JobMaster,Integer> {
    List findAllByJobStatus(String active);

    @Transactional
    @Modifying
    @Query("update JobMaster as jm set jm.jobStatus='Inactive' where jm.jobId=:jobId")
    Integer updateJobStatus(@Param("jobId")Integer jobId);
}
