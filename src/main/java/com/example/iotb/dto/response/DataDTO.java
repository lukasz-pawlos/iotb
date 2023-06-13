package com.example.iotb.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class DataDTO {
    Long id;
    Integer value;
    Date date;
}
