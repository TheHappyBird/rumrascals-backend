package com.rumrascals.rumrascalsbackend.services;

import com.rumrascals.rumrascalsbackend.domain.CompanyRepository;
import com.rumrascals.rumrascalsbackend.domain.RumRepository;
import com.rumrascals.rumrascalsbackend.domain.dto.CompanyReturnDTO;
import com.rumrascals.rumrascalsbackend.domain.dto.RumDTO;
import com.rumrascals.rumrascalsbackend.domain.dto.RumReturnDTO;
import com.rumrascals.rumrascalsbackend.domain.entities.Company;
import com.rumrascals.rumrascalsbackend.domain.entities.Rum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RumService {

    private final RumRepository repository;
    private final CompanyRepository companyRepository;

    @Autowired
    public RumService(RumRepository repository, CompanyRepository companyRepository) {
        this.repository = repository;
        this.companyRepository = companyRepository;
    }

    public Long createRum(RumDTO dto) throws EntityNotFoundException {
        //validateRequest(dto);

        Rum rum = new Rum();
        rum.setName(dto.name);
        rum.setDescription(dto.description);
        rum.setYear(dto.year);

        Company company = companyRepository.findById(dto.companyId)
                .orElseThrow(NoSuchElementException::new);

        rum.setCompany(company);

        repository.save(rum);

        return rum.getId();
    }

    public Long updateRum(Long id, RumDTO dto) throws EntityNotFoundException {
        //validateRequest(dto);

        Rum existingRum = repository.findById(id).get();
        existingRum.setName(dto.name);
        existingRum.setDescription(dto.description);
        existingRum.setYear(dto.year);


        repository.save(existingRum);

        return existingRum.getId();
    }

    private void validateRequest(RumDTO dto) {
        //ObjectValidator.throwIfInvalid(dto);
        if (!companyRepository.findById(dto.companyId).isPresent()) {
            throw new EntityNotFoundException("Unable to find a company with id " + dto.companyId);
        }
    }

    public List<RumReturnDTO> getAllRum() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public RumReturnDTO getRum(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(NoSuchElementException::new);
    }

    public RumReturnDTO deleteRum(Long id) {
        Rum existingRum = repository.findById(id).get();
        repository.delete(existingRum);
        return toDto(existingRum);
    }

    private RumReturnDTO toDto(Rum rum) {
        RumReturnDTO dto = new RumReturnDTO();
        dto.id = rum.getId();
        dto.name = rum.getName();
        dto.description = rum.getDescription();
        dto.year = rum.getYear();
        dto.companyDTO = toCompanyDto(rum.getCompany());
        return dto;
    }

    private CompanyReturnDTO toCompanyDto(Company company) {
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
