package com.study.junit.junitstudyh2.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 *
 *
 * Description : com.study.junit.junitstudyh2.domain.entity
 * </pre>
 *
 * @author
 * @since 2024. 7. 12.
 */


@Entity
@Getter
@Setter
@Table(name = "TB_USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
