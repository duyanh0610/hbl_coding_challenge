package com.example.coding_challenge.controller;

import com.example.coding_challenge.entity.dto.TagDTO;
import com.example.coding_challenge.entity.request.TagRequest;
import com.example.coding_challenge.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/tags")
@AllArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping
    public ResponseEntity<List<TagDTO>> getAll () {
        return ResponseEntity.ok().body(tagService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TagDTO> getOne(@PathVariable String id) throws Exception {
        return ResponseEntity.status(200).body(tagService.getTag(id));
    }

    @PostMapping
    public ResponseEntity<TagDTO> create(@RequestBody TagRequest request) {
        return ResponseEntity.status(201).body(tagService.createTag(request));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TagDTO> update(@PathVariable String id, @RequestBody TagRequest request) throws Exception {
        return ResponseEntity.status(200).body(tagService.updateTag(id, request));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) throws Exception {
        tagService.deleteTag(id);
    }
}
