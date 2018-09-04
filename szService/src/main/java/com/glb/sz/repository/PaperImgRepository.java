package com.glb.sz.repository;

import com.glb.sz.model.entity.PaperImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PaperImgRepository extends JpaRepository<PaperImg,Integer> {

    @Query(value = "select * from paper_img where paper_id=?1",nativeQuery = true)
    List<PaperImg> getImg(Integer paperId);
}
