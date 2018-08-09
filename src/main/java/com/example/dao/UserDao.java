package com.example.dao;

import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.User;

/**
 * UserDao
 *
 * @see src/resources/META-INF/com/example/dao/UserDao
 */
@ConfigAutowireable
@Dao
public interface UserDao {
    @Select
    List<User> selectAll();

    @Insert
    @Transactional
    int insert(User example);
}
