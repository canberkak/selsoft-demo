package com.kft2.selsoftdemo.infrastructure.jpa.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    private static final int ID_LENGTH = 20;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = ID_LENGTH)
    protected Long id;

    @Version
    @Column(name = "row_version")
    protected long rowVersion;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    protected Date createdDate = new Date();

    @LastModifiedDate
    @Column(name = "updated_date")
    @JsonIgnore
    protected Date updatedDate = new Date();

}
