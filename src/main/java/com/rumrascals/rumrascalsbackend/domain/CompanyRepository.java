package com.rumrascals.rumrascalsbackend.domain;

import com.rumrascals.rumrascalsbackend.domain.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
