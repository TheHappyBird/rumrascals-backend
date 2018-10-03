package com.rumrascals.rumrascalsbackend.domain.dto;

import javax.validation.constraints.NotNull;

public class CompanyDTO {
    @NotNull
    public String name;
    public String description;
    public Integer foundedYear;
    public String country;

    public CompanyDTO() {

    }
}
