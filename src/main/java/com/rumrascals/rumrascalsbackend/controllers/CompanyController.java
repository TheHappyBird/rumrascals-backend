package com.rumrascals.rumrascalsbackend.controllers;

import com.rumrascals.rumrascalsbackend.domain.dto.CompanyDTO;
import com.rumrascals.rumrascalsbackend.domain.dto.CompanyReturnDTO;
import com.rumrascals.rumrascalsbackend.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class CompanyController {


    private final CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @RequestMapping(value = "companies", method = RequestMethod.POST)
    public long create(@RequestBody CompanyDTO dto) {
        return service.createCompany(dto);
    }

    @RequestMapping(value = "companies", method = RequestMethod.GET)
    public List<CompanyReturnDTO> list() {
        return service.getAllCompanies();
    }

    @RequestMapping(value = "companies/{id}", method = RequestMethod.GET)
    public CompanyReturnDTO get(@PathVariable Long id) {
        return service.getCompany(id);
    }

    @RequestMapping(value = "companies/{id}", method = RequestMethod.PUT)
    public long update(@PathVariable Long id, @RequestBody CompanyDTO dto) {
        return service.updateCompany(id, dto);
    }

    @RequestMapping(value = "companies/{id}", method = RequestMethod.DELETE)
    public CompanyReturnDTO delete(@PathVariable Long id) {
        return service.deleteCompany(id);
    }

}
