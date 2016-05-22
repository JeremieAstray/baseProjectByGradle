package com.jeremie.spring.home.dao;

import com.jeremie.spring.dao.BaseRepository;
import com.jeremie.spring.home.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

/**
 * @author guanhong 15/8/18 下午4:06.
 */
@Repository
@Table(name = "user")
public interface UserRepository extends BaseRepository<User> {

    @Modifying
    @Query("update User u set u.username= :username where u.id= :id")
    public void update(@Param("username") String username, @Param("id") Long id);

}
