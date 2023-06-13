package com.example.iotb.controller;


import com.example.iotb.dto.request.CreateDataDTO;
import com.example.iotb.dto.request.Interval;
import com.example.iotb.dto.response.DataDTO;
import com.example.iotb.dto.response.DataMmDTO;
import com.example.iotb.model.Pulse;
import com.example.iotb.service.PulseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/pulse")
public class PulseController {
    final PulseService pulseService;

    @PostMapping
    public ResponseEntity<Void> createData(@RequestBody CreateDataDTO request) {
        pulseService.createData(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Pulse>> getData(@RequestParam LocalDateTime start, @RequestParam LocalDateTime end) {
        return ResponseEntity.ok(pulseService.getData(start, end));
    }

    @GetMapping("/mm")
    public ResponseEntity<DataMmDTO> getMinMax(@RequestParam LocalDateTime start, @RequestParam LocalDateTime end) {
        DataMmDTO response = new DataMmDTO(
                start,
                pulseService.getMaxData(start, end),
                pulseService.getMinData(start, end),
                pulseService.getAvgData(start, end)
        );
        return ResponseEntity.ok(response);
    }

}
