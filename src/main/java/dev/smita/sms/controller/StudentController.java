package dev.smita.sms.controller;

import dev.smita.sms.domain.Student;
import dev.smita.sms.dto.StudentResponseDto;
import dev.smita.sms.mapper.StudentMapper;
import dev.smita.sms.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {
    private final StudentService service;

    @GetMapping
        List<StudentResponseDto> students(){
        return service.getStudents().stream()
                .map(StudentMapper::covertStudent).toList();
    }

    @GetMapping("/{roll}")
    StudentResponseDto student(@PathVariable int roll){
        var response = service.getStudent(roll);
        return StudentMapper.covertStudent(response);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    StudentResponseDto createStudent(@RequestBody Student student){
        log.info(student.toString());
        var response =  service.addStudent(student);
        return StudentMapper.covertStudent(response);
    }

    @PutMapping("/{roll}")
    StudentResponseDto updateStudent(@PathVariable int roll,@RequestBody Student student){
        var response = service.updateStudent(roll,student);
        return StudentMapper.covertStudent(response);
    }

    @DeleteMapping("/{roll}")

    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteStudent(@PathVariable int roll){
        service.removeStudent(roll);
    }

    @PatchMapping("/{roll}/increment/{fee}")
    public void incrementFee(@PathVariable int roll,@PathVariable double fee){
        service.incrementFee(roll,fee);
    }
}
