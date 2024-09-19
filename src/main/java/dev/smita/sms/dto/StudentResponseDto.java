package dev.smita.sms.dto;

import dev.smita.sms.domain.Address;
import lombok.Data;

@Data
public class StudentResponseDto {
    private int roll;
    private String name;
    private double fee;
    private String email;
    private Address address;
    private  StudentDetailResponseDto studentDetail;
}
