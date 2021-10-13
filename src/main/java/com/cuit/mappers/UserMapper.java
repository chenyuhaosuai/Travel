package com.cuit.mappers;

import com.cuit.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> findAll();

    int save(User user);

    User findUserByNameAndPassword(User user);
}
