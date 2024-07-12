package com.study.junit.junitstudyh2.api.user;

import com.study.junit.junitstudyh2.domain.entity.UserEntity;
import com.study.junit.junitstudyh2.domain.entity.UserRepository;
import org.hibernate.annotations.Comment;
import org.hibernate.service.spi.ServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * <pre>
 *
 *
 * Description : com.study.junit.junitstudyh2.api.user
 * </pre>
 *
 * @author
 * @since 2024. 7. 12.
 */

@DataJpaTest
class UserServiceTest {

//    @Autowired
//    private UserRepository userRepository;
//
//    @BeforeEach
//    public void setUp() {
//    }
//
//    @Test
//    @Comment("저장")
//    public void testSaveAndFind() {
//        UserEntity user = new UserEntity();
//        user.setName("천혜인");
//        userRepository.save(user);
//
//        UserEntity foundUser = userRepository.findById(user.getId()).orElse(null);
//        assertNotNull(foundUser);
//        assertEquals("천혜인", foundUser.getName());
//
//    }
//
//    @Test
//    @Comment("모두 찾기")
//    public void testFind() {
//        List<UserEntity> users = userRepository.findAll();
//        assertNotNull(users);
//    }

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser() {
        UserEntity user = new UserEntity();
        user.setName("천혜인");
        when(userRepository.save(any(UserEntity.class))).thenReturn(user);

        UserEntity savedUser = userService.saveUser("천혜인");
        assertNotNull(savedUser);
        assertEquals("천혜인", savedUser.getName());
    }

    @Test
    public void testGetUserById() throws Exception {
        UserEntity user = new UserEntity();
        user.setName("천혜인");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<UserEntity> foundUser = userService.getUserById(1L);
        assertTrue((BooleanSupplier) foundUser.orElseThrow(Exception::new));
        assertEquals("천혜인", foundUser.get().getName());
    }


}
