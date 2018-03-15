package com.hgicreate.rno.service;

/**
 * 用户接口
 *
 * @author chen.c10
 */
public interface UserService {
    /**
     * 判断用户是否存在
     *
     * @param username 用户名
     * @return 是否存在
     */
    boolean existsByUsername(String username);
}
