package dev.smita.sms.mapper;

import dev.smita.sms.domain.Student;
import dev.smita.sms.dto.StudentDetailResponseDto;
import dev.smita.sms.dto.StudentResponseDto;
import org.springframework.beans.BeanUtils;

public class StudentMapper {
    public static StudentResponseDto covertStudent(Student student){
        var response = new StudentResponseDto();
        BeanUtils.copyProperties(student,response);

        var studentDetailResponseDto = new StudentDetailResponseDto();
        BeanUtils.copyProperties(student.getStudentDetail(),studentDetailResponseDto);
        response.setStudentDetail(studentDetailResponseDto);

        return response;
    }
}
