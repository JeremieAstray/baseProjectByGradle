package com.jeremie.service.commons.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author guanhong 15/9/12 下午3:35.
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", updatable = false, nullable = false)
    protected Long id;

    /**
     * valid的值默认为true
     */
    @Column
    protected Boolean valid = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
