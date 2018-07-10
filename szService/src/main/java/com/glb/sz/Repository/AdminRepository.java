package com.glb.sz.Repository;

import com.glb.sz.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AdminRepository extends JpaRepository<Admin,Integer> {


    @Query(value = "select * from admin",nativeQuery = true)
    List<Admin> getAllAdmin();
}
