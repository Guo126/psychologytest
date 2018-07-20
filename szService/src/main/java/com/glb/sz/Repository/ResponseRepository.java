package com.glb.sz.Repository;

import com.glb.sz.model.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Integer> {

    @Query(value = "select * from response where paper_id=?1", nativeQuery = true)
    List<Response> getResponseByPaper(Integer paperId);
}
