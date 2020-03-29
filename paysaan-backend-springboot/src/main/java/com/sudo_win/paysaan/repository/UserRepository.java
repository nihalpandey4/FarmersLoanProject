package com.sudo_win.paysaan.repository;

import com.sudo_win.paysaan.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByPhoneNo(Long phoneno);
}
