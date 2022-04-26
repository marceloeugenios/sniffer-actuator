package com.acp.aptiv.sniffer.dto;

import com.acp.aptiv.sniffer.dto.util.Git;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ActuatorDto {

    @Setter
    @JsonProperty(value = "service")
    private ServiceDto serviceDto;
    private Git git;

}
