package com.rumrascals.rumrascalsbackend.domain;

import com.rumrascals.rumrascalsbackend.domain.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}