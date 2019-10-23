package com.rumrascals.rumrascalsbackend.Util;

import com.rumrascals.rumrascalsbackend.domain.dto.CompanyReturnDTO;
import com.rumrascals.rumrascalsbackend.domain.dto.RumReturnDTO;
import com.rumrascals.rumrascalsbackend.domain.dto.TagReturnDTO;
import com.rumrascals.rumrascalsbackend.domain.entities.Company;
import com.rumrascals.rumrascalsbackend.domain.entities.Rum;
import com.rumrascals.rumrascalsbackend.domain.entities.Tag;

public class DomainConverter {

    public RumReturnDTO toRumDto(Rum rum) {
        if (rum == null) return null;
        RumReturnDTO dto = new RumReturnDTO();
        dto.id = rum.getId();
        dto.name = rum.getName();
        dto.description = rum.getDescription();
        dto.year = rum.getYear();
        dto.companyDTO = toCompanyDto(rum.getCompany());
        return dto;
    }

    public CompanyReturnDTO toCompanyDto(Company company) {
        if (company == null) return null;
        CompanyReturnDTO dto = new CompanyReturnDTO();
        dto.id = company.getId();
        dto.name = company.name;
        dto.description = company.description;
        dto.foundedYear = company.foundedYear;
        dto.country = company.country;

        return dto;
    }

    public TagReturnDTO toTagDto(Tag tag) {
        if (tag == null) return null;
        TagReturnDTO dto = new TagReturnDTO();
        dto.id = tag.getId();
        dto.name = tag.name;
        dto.description = tag.description;

        return dto;
    }
}