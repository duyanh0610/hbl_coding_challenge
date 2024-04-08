package com.example.coding_challenge.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;

    @CreationTimestamp
    @Column(name = "createTime")
    private LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(name = "updatedTime")
    private LocalDateTime updatedTime;

    @Column(name = "isDelete")
    private boolean isDelete;
}
