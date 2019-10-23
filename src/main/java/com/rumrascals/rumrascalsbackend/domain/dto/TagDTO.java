package com.rumrascals.rumrascalsbackend.domain.dto;

import javax.validation.constraints.NotNull;

public class TagDTO {
    @NotNull
    public String name;
    public String description;

    public TagDTO() {}
}