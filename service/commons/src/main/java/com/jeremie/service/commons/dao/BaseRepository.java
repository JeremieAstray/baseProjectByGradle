package com.jeremie.service.commons.dao;

import com.jeremie.spring.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author guanhong 15/9/12 下午3:25.
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

    void invalid(Iterable<? extends T> entities);

    void invalid(T entity);

    void invalid(Long id);

    void invalidAll();

    void valid(Iterable<? extends T> entities);

    void valid(T entity);

    void valid(Long id);

    void validAll();
}
