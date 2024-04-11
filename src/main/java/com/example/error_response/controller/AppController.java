package com.example.error_response.controller;

import com.example.error_response.ApiResponse;
import com.example.error_response.exception.CustomException;
import com.example.error_response.exception.ErrorCode;
import com.example.error_response.exception.Restrict;
import com.example.error_response.studentContainer.Student;
import com.example.error_response.studentContainer.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AppController extends BaseController {

    private StudentService studentService;

    @GetMapping("/student/{name}/{grade}")
    public ApiResponse<Student> add(
            @PathVariable("name") String name,
            @PathVariable("grade") int grade
    ){
        if(grade > 5) {
            throw new CustomException(ErrorCode.CANCLE, "grade 는 6이상 입력 할 수 없습니다.", new Restrict(5));
        }

        Student student = studentService.addStudent(name,grade);
        return makeApiResponse(student);
    }

    @GetMapping("/student/ordered")
    public ApiResponse<Student> getOrdered(){
        List<Student> students = studentService.getOrderedStudents();
        return makeApiResponse(students);
    }

    @GetMapping("/student/{grade}")
    public ApiResponse<Student> getBy(
            @PathVariable("grade") int grade){
        List<Student> students = studentService.getByStudent(grade);
        return makeApiResponse(students);
    }

}
