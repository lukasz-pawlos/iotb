package com.example.iotb.controller;


import com.example.iotb.dto.request.CreateDataDTO;
import com.example.iotb.dto.request.Interval;
import com.example.iotb.dto.response.DataMmDTO;
import com.example.iotb.model.Pulse;
import com.example.iotb.model.SpO2;
import com.example.iotb.service.SpO2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sp02")
public class SpO2Controller {

    final SpO2Service SpO2Service;

    @PostMapping
    public ResponseEntity<Void> createData(@RequestBody CreateDataDTO request) {
        SpO2Service.createData(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<SpO2>> getData(@RequestParam LocalDateTime start, @RequestParam LocalDateTime end) {
        return ResponseEntity.ok(SpO2Service.getData(start, end));
    }

    @GetMapping("/mm")
    public ResponseEntity<DataMmDTO> getMinMax(@RequestParam LocalDateTime start, @RequestParam LocalDateTime end) {
        DataMmDTO response = new DataMmDTO(
                start,
                SpO2Service.getMaxData(start, end),
                SpO2Service.getMinData(start, end),
                SpO2Service.getAvgData(start, end)
        );
        return ResponseEntity.ok(response);
    }
}
