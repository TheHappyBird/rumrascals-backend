package com.rumrascals.rumrascalsbackend.controllers;

import com.rumrascals.rumrascalsbackend.domain.dto.TagDTO;
import com.rumrascals.rumrascalsbackend.domain.dto.TagReturnDTO;
import com.rumrascals.rumrascalsbackend.services.TagService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/tag")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public long create(@RequestBody TagDTO tag) {
        return tagService.createTag(tag);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TagReturnDTO> list() {
        return tagService.getAllTag();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public TagReturnDTO get(@PathVariable Long id) {
        return tagService.getTag(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public long update(@PathVariable Long id, @RequestBody TagDTO tag) {
        return tagService.updateTag(id, tag);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public TagReturnDTO delete(@PathVariable Long id) {
        return tagService.deleteTag(id);
    }
}