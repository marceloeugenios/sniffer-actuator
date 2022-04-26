package com.acp.aptiv.sniffer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto {

    private String name;
    private String environment;
    private String url;
}
