package com.example.coding_challenge.entity.request;

import com.example.coding_challenge.entity.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
public class CustomerRequest {
    @NotBlank
    private String name;
    private List<Tag> tags;
}
