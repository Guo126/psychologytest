package com.glb.sz.repository;

import com.glb.sz.model.dto.UserAnswerDTO;
import com.glb.sz.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user where username=?1 and password=md5(?2)", nativeQuery = true)
    User getUser(String username, String password);

    @Query(value = "select * from user where user_id=?1", nativeQuery = true)
    User getUser(Integer userId);


    @Query(value = "update user set token=?2 where user_id=?1", nativeQuery = true)
    @Modifying
    int login(Integer userId, String token);

    @Query(value = "select token from user where username=?1 and password=md5(?2)", nativeQuery = true)
    String getToken(String username, String password);

    @Query(value = "update user set token='NotOnline' where user_id=?1", nativeQuery = true)
    @Modifying
    int logout(Integer userId);

    @Query(value = "insert into user(username,password,nickname,sex,phone,mail,self_desc,birthday,token) values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)",nativeQuery = true)
    @Modifying
    void saveUser(String username, String password, String nickname, String sex, String phone, String mail,String desc,Date birthday,String token,Integer userLevel);

    @Query("select new com.glb.sz.model.dto.UserAnswerDTO(u.nickname,r.responseDesc,p.paperDesc) " +
            "from Paper p,Response r,User u,Score s " +
            "where u.userId=?1 and s.userId=u.userId and s.responseId=r.responseId and r.paperId=p.paperId")
    List<UserAnswerDTO> getUserResponseList(Integer userId);

    @Query(value = "update user set user_level=?2 where user_id=?1",nativeQuery = true)
    @Modifying
    int setUserLevel(Integer userId,Integer userLevel);

    @Query(value = "delete from user where user_id=?1",nativeQuery = true)
    @Modifying
    int deleteUser(Integer userId);

    @Query(value = "select * from user where nickname like %?1%",nativeQuery = true)
    List<User> searchUser(String nickname);
}
