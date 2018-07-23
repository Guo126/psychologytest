package com.glb.sz.Repository;

import com.glb.sz.model.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Integer> {

    @Query(value = "select * from response where paper_id=?1", nativeQuery = true)
    List<Response> getResponseByPaper(Integer paperId);

    @Query(value = "select * from response as r where r.paper_id=?1 and r.score_min=(" +
            "select max(r1.score_limit) " +
            "from response as r1 " +
            "where r1.score_min<?2)",nativeQuery = true)
    Response getResponse(Integer paperId,Integer score);
}
