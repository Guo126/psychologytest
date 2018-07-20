package com.glb.sz.Repository;

import com.glb.sz.model.dto.UserAnswerDTO;
import com.glb.sz.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select * from user where username=?1 and password=md5(?2)",nativeQuery = true)
    User getUser(String username,String password);

    @Query(value = "select * from user where user_id=?1",nativeQuery = true)
    User getUser(Integer userId);


    @Query(value = "update user set token=?2 where user_id=?1",nativeQuery = true)
    @Modifying
    int login(Integer userId,String token);

    @Query(value = "select token from user where username=?1 and password=md5(?2)",nativeQuery = true)
    String getToken(String username,String password);

    @Query(value = "update user set token='NotOnline' where user_id=?1",nativeQuery = true)
    int logout(Integer userId);


    @Query("select new com.glb.sz.model.dto.UserAnswerDTO(u.nickname,r.responseDesc,p.paperDesc) " +
            "from Paper p,Response r,User u,User_Response ur " +
            "where u.userId=?1 and ur.userId=u.userId and ur.responseId=r.responseId and r.paperId=p.paperId")
    List<UserAnswerDTO> getUserResponseList(Integer userId);
}
