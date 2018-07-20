package com.glb.sz.Repository;

import com.glb.sz.model.entity.User_Response;
import com.glb.sz.model.entity.pk.User_Response_ID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_Response_Repository extends JpaRepository<User_Response,User_Response_ID> {
}
