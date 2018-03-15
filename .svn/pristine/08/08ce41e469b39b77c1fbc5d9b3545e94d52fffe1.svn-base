package com.hgicreate.rno.service;

import com.hgicreate.rno.repo.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author chen.c10
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
