package dev.smita.sms.service;

import dev.smita.sms.domain.StudentDetail;
import dev.smita.sms.dto.StudentDetailResponseDto;
import dev.smita.sms.dto.StudentResponseDto;
import dev.smita.sms.repository.StudentDetailRepository;
import dev.smita.sms.repository.StudentRepository;
import dev.smita.sms.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentDetailRepository studentDetailRepository;

    public Student addStudent(Student student){
        student.getStudentDetail().setStudent(student);
        return studentRepository.save(student);
    }
    public List<Student> getStudents(){
        return  studentRepository.findAll();
    }
    public Student getStudent(int roll){
        return studentRepository.findById(roll).orElseThrow();
    }

    public Student updateStudent(int roll,Student student){
        student.setRoll(roll);
        studentRepository.save(student);
        return student;
    }

    public void removeStudent(int roll){
        studentRepository.deleteById(roll);
    }

    public void incrementFee(int roll,double fee){
        studentRepository.incrementByFee(fee,roll);
    }
}
