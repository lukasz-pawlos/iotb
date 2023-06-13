package com.example.iotb.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CreateDataDTO {
    Integer value;
    Date date;
}
