package com.unal.cronus.model.mapper;

import com.unal.cronus.model.dto.StudentDto;
import com.unal.cronus.model.entitity.Student;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;
@MapperConfig
public interface StudentMapperConfig extends UserMapperConfig{
    @InheritConfiguration(name = "mapUser")
    void mapStudent(Student student,@MappingTarget  StudentDto studentDto);
}
