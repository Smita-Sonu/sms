package dev.smita.sms.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student {
    @Id
    private int roll;
    private String name;
    private double fee;
    private String email;
    @Embedded
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_detail_id")
    private StudentDetail studentDetail;
}
