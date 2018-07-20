package com.glb.sz.Repository;

import com.glb.sz.model.entity.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaperRepository extends JpaRepository<Paper,Integer> {

    @Query(value = "select * from paper",nativeQuery = true)
    List<Paper> getPaperList();


}
