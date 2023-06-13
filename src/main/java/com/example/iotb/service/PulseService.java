package com.example.iotb.service;

import com.example.iotb.dto.request.CreateDataDTO;
import com.example.iotb.model.Pulse;
import com.example.iotb.repository.PulseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PulseService {

    final PulseRepository pulseRepository;

    public void createData(CreateDataDTO request) {
        Pulse data = new Pulse(
                request.getValue(),
                request.getDate());
        pulseRepository.save(data);
    }

    public List<Pulse> getData(LocalDateTime start, LocalDateTime end) {
        return pulseRepository.findValuesByDateRange(start, end);
    }

    public Integer getMaxData(LocalDateTime start, LocalDateTime end) {
        return pulseRepository.findMaxValueByDateRange(start, end);
    }

    public Integer getAvgData(LocalDateTime start, LocalDateTime end) {
        return pulseRepository.findAvgValueByDateRange(start, end);
    }

    public Integer getMinData(LocalDateTime start, LocalDateTime end) {
        return pulseRepository.findMinValueByDateRange(start, end);
    }
}
