package com.example.coding_challenge.service;

import com.example.coding_challenge.entity.Customer;
import com.example.coding_challenge.entity.Tag;
import com.example.coding_challenge.entity.dto.TagDTO;
import com.example.coding_challenge.entity.request.TagRequest;

import java.util.List;

public interface TagService {
    List<TagDTO> getAll();

    TagDTO getTag(String id) throws Exception;

    TagDTO createTag(TagRequest request);

    TagDTO updateTag(String id, TagRequest request) throws Exception;

    void deleteTag(String id) throws Exception;
}
