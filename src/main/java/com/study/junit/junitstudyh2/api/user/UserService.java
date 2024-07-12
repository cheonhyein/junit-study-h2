package com.study.junit.junitstudyh2.api.user;

import com.study.junit.junitstudyh2.domain.entity.UserEntity;
import com.study.junit.junitstudyh2.domain.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <pre>
 *
 *
 * Description : com.study.junit.junitstudyh2.api.user.service
 * </pre>
 *
 * @author
 * @since 2024. 7. 12.
 */

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity saveUser(String name) {
        UserEntity user = new UserEntity();
        user.setName(name);
        return userRepository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

}
