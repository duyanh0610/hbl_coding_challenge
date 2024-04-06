package com.example.coding_challenge.entity;

import java.time.LocalDateTime;

public class BaseEntity {
    private String id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedTime;
    private boolean isDelete;
}
