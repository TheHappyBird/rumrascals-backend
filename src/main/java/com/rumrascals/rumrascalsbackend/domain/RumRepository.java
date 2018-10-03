package com.rumrascals.rumrascalsbackend.domain;

import com.rumrascals.rumrascalsbackend.domain.entities.Rum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RumRepository extends JpaRepository<Rum, Long> {
}
