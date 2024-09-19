package dev.smita.sms.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student_detail")
@Data
public class StudentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slNo;
    private String motherName;
    private String fatherName;
    private String aadharNumber;
    @OneToOne(mappedBy = "studentDetail")
    private Student student;
}
