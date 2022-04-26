package com.acp.aptiv.sniffer.service;

import com.acp.aptiv.sniffer.dto.ActuatorDto;
import com.acp.aptiv.sniffer.dto.ServiceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActuatorReportImpl implements ActuatorReportService {

    private static final List<ServiceDto> SERVICES;

    private final RestTemplate restTemplate;

    static {
        SERVICES = new ArrayList<>();
        SERVICES.add(new ServiceDto("deposito", "dev", "http://localhost:8080/actuator/info"));
    }

    @Override
    public List<ActuatorDto> process() {
        try {
            return SERVICES.stream().map(serviceDto -> {
                var authResponse = restTemplate.exchange(serviceDto.getUrl(), HttpMethod.GET, null,
                        new ParameterizedTypeReference<ActuatorDto>() {
                        });
                var actuatorDto = authResponse.getBody();
                actuatorDto.setServiceDto(serviceDto);
                return actuatorDto;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
