package com.glb.sz.Repository;

import com.glb.sz.model.entity.ResponseImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResponseImgRepository extends JpaRepository<ResponseImg,Integer> {

    @Query(value = "select * from response_img where response_id=?1",nativeQuery = true)
    List<ResponseImg> getImg(Integer responseId);
}
