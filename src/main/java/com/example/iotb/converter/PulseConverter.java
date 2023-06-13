package com.example.iotb.converter;

import com.example.iotb.dto.request.CreateDataDTO;
import com.example.iotb.dto.response.DataDTO;
import com.example.iotb.model.Pulse;

import java.util.List;
import java.util.stream.Collectors;

public class PulseConverter {

    public static Pulse convertToEntity(CreateDataDTO request) {
        return new Pulse(
                request.getValue(),
                request.getDate());
    }

    public static DataDTO convertToDTO(Pulse pulse) {
        return new DataDTO(
                pulse.getId(),
                pulse.getValue(),
                pulse.getDate()
        );
    }

    public static List<DataDTO> convertToDTOs(List<Pulse> pulses) {
        return pulses
                .stream()
                .map(PulseConverter::convertToDTO)
                .collect(Collectors.toList());
    }
}
