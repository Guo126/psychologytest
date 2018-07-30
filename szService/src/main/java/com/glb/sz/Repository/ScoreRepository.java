package com.glb.sz.Repository;

import com.glb.sz.model.dto.ResponseWithMinScoreDTO;
import com.glb.sz.model.dto.UserAnswerDTO;
import com.glb.sz.model.entity.Score;
import com.glb.sz.model.entity.pk.Score_ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ScoreRepository extends JpaRepository<Score,Score_ID> {

    @Query(value = "select * from score where user_id=?1",nativeQuery = true)
    List<Score> getUserAllScore(Integer userId);

    @Query(value = "select * from score where user_id=?1 and response_id=?2",nativeQuery = true)
    Score getUserScore(Integer userId,Integer responseId);

    @Query(value = "select new com.glb.sz.model.dto.UserAnswerDTO(u.nickname,r.responseDesc,p.paperDesc) " +
            "from User u,Response r,Paper p,Score s " +
            "where u.userId=?1 and u.userId=s.userId and s.responseId=r.responseId and r.paperId=p.paperId")
    List<UserAnswerDTO> getUserAnswer(Integer userId);
}
