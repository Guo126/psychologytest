package com.glb.sz.Repository;

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


}
