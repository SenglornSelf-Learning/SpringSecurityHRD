package com.springsecurity.repository.userIinMemory;

import com.springsecurity.entity.userIinMemory.AppUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserRepository {
    @Insert("""
        INSERT INTO users (name, email, password, role)
        VALUES (#{user.name}, #{user.email}, #{user.password}, #{user.role})
        """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    AppUser insertUser(@Param("user") AppUser appUserRequest);

    @Select("SELECT * FROM users WHERE email = #{email}")
    AppUser findUserByEmail(String email);
}
