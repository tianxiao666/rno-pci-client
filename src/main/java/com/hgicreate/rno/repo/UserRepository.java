package com.hgicreate.rno.repo;

import com.hgicreate.rno.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author chen.c10
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 通过用户名获取用户对象
     *
     * @param username 用户名
     * @return 用户对象
     */
    User findByUsername(@Param("username") String username);

    /**
     * 通过用户名判断用户是否存在
     *
     * @param username 用户名
     * @return 是否存在
     */
    Boolean existsByUsername(String username);
}