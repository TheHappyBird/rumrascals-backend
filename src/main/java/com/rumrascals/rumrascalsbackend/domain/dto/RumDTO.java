package com.rumrascals.rumrascalsbackend.domain.dto;

import javax.validation.constraints.NotNull;

public class RumDTO {
    @NotNull
    public String name;
    public String description;
    public Integer year;
    @NotNull
    public Long companyId;

    public RumDTO() {

    }
}
