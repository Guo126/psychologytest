package com.glb.sz.repository;

import com.glb.sz.model.entity.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaperRepository extends JpaRepository<Paper,Integer> {

    @Query(value = "select * from paper where state_id=1",nativeQuery = true)
    List<Paper> getPaperList();

    @Query(value = "update paper set paper_desc=?2 where paper_id=?1 and state_id=1",nativeQuery = true)
    @Modifying
    Integer renamePaper(Integer paperId,String newName);

    @Query(value = "update paper set state_id=2 where paper_id=?1 and state_id=1",nativeQuery = true)
    @Modifying
    Integer deletePaper(Integer paperId);

    @Query(value = "select * from paper where paper_desc like %?1% and state_id=1",nativeQuery = true)
    List<Paper> search(String paperDesc);

    @Query(value = "select * from paper  p " +
            "where not exists(" +
            "select * from score as s,user as u,response as r " +
            "where u.user_id=s.user_id and s.response_id=r.response_id and r.paper_id=p.paper_id and u.user_id=?1) " +
            "and p.state_id=1",
            nativeQuery = true)
    List<Paper> getPaperByUser(Integer userId);
}
