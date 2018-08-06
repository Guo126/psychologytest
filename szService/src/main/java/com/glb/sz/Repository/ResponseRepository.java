package com.glb.sz.Repository;

import com.glb.sz.model.dto.ResponseWithMinScoreDTO;
import com.glb.sz.model.dto.SearchResponseResultDTO;
import com.glb.sz.model.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Integer> {

    @Query(value = "select * from response where paper_id=?1 and state_id=1", nativeQuery = true)
    List<Response> getResponseByPaper(Integer paperId);

    @Query(value = "select * from response as r where r.state_id=1 and r.paper_id=?1 and r.score_min=(" +
            "select max(r1.score_min) " +
            "from response as r1 " +
            "where r1.score_min<=?2)",nativeQuery = true)
    Response getResponse(Integer paperId,Integer score);


    @Query(value = "select new com.glb.sz.model.dto.ResponseWithMinScoreDTO(r.scoreMin,r.responseDesc,r.responseId) " +
            "from Response r where r.paperId=?1 and r.stateId=1")
    List<ResponseWithMinScoreDTO> getResponse(Integer paperId);

    @Query(value = "update response set score_min=?2 where response_id=?1 and state_id=1",nativeQuery = true)
    @Modifying
    Integer resetResponse(Integer responseId,String responseDesc);

    @Query(value = "update response set response_desc=?2 where response_id=?1 and state_id=1",nativeQuery = true)
    @Modifying
    Integer resetResponseMinScore(Integer responseId,Integer minScore);

    @Query(value = "update response set state_id=2 where response_id=?1 and state_id=1",nativeQuery = true)
    @Modifying
    Integer deleteResponse(Integer responseId);

    @Query(value = "select new com.glb.sz.model.dto.SearchResponseResultDTO(r.responseDesc,p.paperDesc,r.scoreMin) " +
            "from Response r,Paper p " +
            "where r.responseDesc like %?1% and r.paperId=p.paperId and p.stateId=1")
    List<SearchResponseResultDTO> search(String responseDesc);
}
