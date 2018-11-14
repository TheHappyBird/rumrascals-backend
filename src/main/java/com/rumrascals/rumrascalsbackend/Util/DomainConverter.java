package com.rumrascals.rumrascalsbackend.Util;

import com.rumrascals.rumrascalsbackend.domain.dto.CompanyReturnDTO;
import com.rumrascals.rumrascalsbackend.domain.dto.RumReturnDTO;
import com.rumrascals.rumrascalsbackend.domain.entities.Company;
import com.rumrascals.rumrascalsbackend.domain.entities.Rum;

public class DomainConverter {

    public RumReturnDTO toRumDto(Rum rum) {
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
}
