package com.example.iotb.service;

import com.example.iotb.dto.request.CreateDataDTO;
import com.example.iotb.model.Pulse;
import com.example.iotb.model.SpO2;
import com.example.iotb.repository.PulseRepository;
import com.example.iotb.repository.SpO2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpO2Service {

    final SpO2Repository SpO2Repository;

    public void createData(CreateDataDTO request) {
        SpO2 data = new SpO2(
                request.getValue(),
                request.getDate());
        SpO2Repository.save(data);
    }

    public List<SpO2> getData(LocalDateTime start, LocalDateTime end) {
        return SpO2Repository.findValuesByDateRange(start, end);

    }

    public Integer getMaxData(LocalDateTime start, LocalDateTime end) {
        return SpO2Repository.findMaxValueByDateRange(start, end);
    }

    public Integer getAvgData(LocalDateTime start, LocalDateTime end) {
        return SpO2Repository.findAvgValueByDateRange(start, end);
    }


    public Integer getMinData(LocalDateTime start, LocalDateTime end) {
        return SpO2Repository.findMinValueByDateRange(start, end);
    }
}
