package com.example.iotb.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class DataMmDTO {
    LocalDateTime date;
    Integer max;
    Integer min;
    Integer avg;
}
