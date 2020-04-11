package com.example.dao;

import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.entity.base.User;

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

    @Select
    User selectByEmail(String email);

    @Insert
    int insert(User example);
}
