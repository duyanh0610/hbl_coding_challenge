package com.example.coding_challenge.service.impl;

import com.example.coding_challenge.entity.BaseEntity;
import com.example.coding_challenge.entity.Tag;
import com.example.coding_challenge.entity.dto.TagDTO;
import com.example.coding_challenge.entity.request.TagRequest;
import com.example.coding_challenge.repository.TagRepository;
import com.example.coding_challenge.service.TagService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TagDTO> getAll() {
        List<Tag> tags = tagRepository.findAll();
        return tags.stream()
            .filter(tag -> !tag.isDelete())
            .map(tag -> modelMapper.map(tag, TagDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public TagDTO getTag(String id) throws Exception {
        Tag tag = tagRepository.findById(id)
            .orElseThrow(() -> new Exception("Tag not found"));
        return modelMapper.map(tag, TagDTO.class);
    }

    @Override
    public TagDTO createTag(TagRequest request) {
        Tag tag = modelMapper.map(request, Tag.class);
        tagRepository.save(tag);
        return modelMapper.map(tag, TagDTO.class);
    }

    @Override
    public TagDTO updateTag(String id, TagRequest request) throws Exception {
        Tag tag = tagRepository.findById(id)
            .orElseThrow(() -> new Exception("Tag not found"));
        tag.setTitle(request.getTitle());

        tagRepository.save(tag);
        return modelMapper.map(tag, TagDTO.class);
    }

    @Override
    public void deleteTag(String id) throws Exception {
        Tag tag = tagRepository.findById(id)
            .orElseThrow(() -> new Exception("Tag not found"));
        tag.setDelete(true);
        tagRepository.save(tag);
    }
}
