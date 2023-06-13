package com.example.iotb.converter;

import com.example.iotb.dto.request.CreateDataDTO;
import com.example.iotb.dto.response.DataDTO;
import com.example.iotb.model.Pulse;
import com.example.iotb.model.SpO2;

import java.util.List;
import java.util.stream.Collectors;

public class SpO2Converter {

    public static SpO2 convertToEntity(CreateDataDTO request) {
        return new SpO2(
                request.getValue(),
                request.getDate());
    }

    public static DataDTO convertToDTO(SpO2 pulse) {
        return new DataDTO(
                pulse.getId(),
                pulse.getValue(),
                pulse.getDate()
        );
    }

    public static List<DataDTO> convertToDTOs(List<SpO2> pulses) {
        return pulses
                .stream()
                .map(SpO2Converter::convertToDTO)
                .collect(Collectors.toList());
    }
}


