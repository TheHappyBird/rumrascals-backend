package com.rumrascals.rumrascalsbackend.services;

import com.rumrascals.rumrascalsbackend.Util.DomainConverter;
import com.rumrascals.rumrascalsbackend.domain.RumRepository;
import com.rumrascals.rumrascalsbackend.domain.TagRepository;
import com.rumrascals.rumrascalsbackend.domain.dto.TagDTO;
import com.rumrascals.rumrascalsbackend.domain.dto.TagReturnDTO;
import com.rumrascals.rumrascalsbackend.domain.entities.Tag;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TagService {

    private final TagRepository tagRepository;
    private final RumRepository rumRepository;
    private final DomainConverter domainConverter;

    public TagService(TagRepository tagRepository, RumRepository rumRepository) {
        this.tagRepository = tagRepository;
        this.rumRepository = rumRepository;
        this.domainConverter = new DomainConverter();
    }

    public Long createTag(TagDTO dto) throws EntityExistsException {
        //validateRequest(dto);

        Tag tag = new Tag();

        return null;
    }

    public Long updateTag(Long id, TagDTO dto) throws EntityNotFoundException {
        return null;
    }

    public List<TagReturnDTO> getAllTag() {
        return null;
    }

    public TagReturnDTO getTag(Long id) {
        return null;
    }

    public TagReturnDTO deleteTag(Long id) {
        return null;
    }

    private void validateRequest(TagDTO dto){}

    private TagReturnDTO toDTO(Tag tag) {
        return domainConverter.toTagDto(tag);
    }
}
