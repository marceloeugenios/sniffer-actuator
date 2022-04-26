package com.acp.aptiv.sniffer.controller;

import com.acp.aptiv.sniffer.dto.ActuatorDto;
import com.acp.aptiv.sniffer.service.ActuatorReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/report")
public class ActuatorReportController {

    private final ActuatorReportService actuatorReportService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActuatorDto>> processActuatorReport(
            @RequestParam(value = "service", required = false) String service) {
        return ResponseEntity.ok(actuatorReportService.process(service));
    }
}
