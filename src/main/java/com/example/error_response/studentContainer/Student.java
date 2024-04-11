package com.example.error_response.studentContainer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student implements Comparable<Student>{
    private String name;
    private int grade;

    @Override
    public int compareTo(Student student) {
        return this.grade - student.grade;
    }
}
