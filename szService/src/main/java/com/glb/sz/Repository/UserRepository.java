package com.glb.sz.Repository;

import com.glb.sz.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value="select * from user" ,nativeQuery = true)
    List<User> getAllUser();


    @Query(value = "select * from user " +
            "where user_name=?1 and user_password=?2",nativeQuery = true)
    User findByLogin(String username,String password);

}
