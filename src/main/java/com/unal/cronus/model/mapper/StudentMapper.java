package com.unal.cronus.model.mapper;

import com.unal.cronus.model.dto.StudentDto;
import com.unal.cronus.model.entitity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",config = StudentMapperConfig.class)
public abstract class StudentMapper {
    public abstract Student mapStudent(StudentDto studentDto);
    public abstract StudentDto mapStudent(Student student);

}
