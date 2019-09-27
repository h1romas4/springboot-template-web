package com.example.entity.base;

import java.time.LocalDateTime;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Column;

/**
 * User
 */
@Entity
@Table(name = "m_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public String attr;
    @Column(insertable = false)
    public LocalDateTime created;
    @Column(insertable = false)
    public LocalDateTime updated;
}
