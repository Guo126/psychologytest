package com.glb.sz.Repository;

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

}
