package com.rumrascals.rumrascalsbackend.services;

import com.rumrascals.rumrascalsbackend.domain.CompanyRepository;
import com.rumrascals.rumrascalsbackend.domain.dto.CompanyDTO;
import com.rumrascals.rumrascalsbackend.domain.dto.CompanyReturnDTO;
import com.rumrascals.rumrascalsbackend.domain.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public Long createCompany(CompanyDTO dto) {

        Company company = new Company();
        company.name = dto.name;
        company.description = dto.description;
        company.foundedYear = dto.foundedYear;
        company.country = dto.country;

        repository.save(company);

        return company.getId();
    }

    public Long updateCompany(Long id, CompanyDTO dto) {
        Company existingCompany = repository.findById(id).get();
        existingCompany.name = dto.name;
        existingCompany.description = dto.description;
        existingCompany.foundedYear = dto.foundedYear;
        existingCompany.country = dto.country;

        repository.save(existingCompany);

        return existingCompany.getId();
    }

    public List<CompanyReturnDTO> getAllCompanies() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public CompanyReturnDTO getCompany(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(NoSuchElementException::new);
    }

    public CompanyReturnDTO deleteCompany(Long id) {
        Company existingCompany = repository.findById(id).get();
        repository.delete(existingCompany);
        return toDto(existingCompany);
    }

    private CompanyReturnDTO toDto(Company company) {
        CompanyReturnDTO dto = new CompanyReturnDTO();
        dto.id = company.getId();
        dto.name = company.name;
        dto.description = company.description;
        dto.foundedYear = company.foundedYear;
        dto.country = company.country;

        return dto;
    }
}
