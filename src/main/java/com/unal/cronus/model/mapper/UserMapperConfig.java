package com.unal.cronus.model.mapper;

import com.unal.cronus.model.dto.UserDto;
import com.unal.cronus.model.entitity.User;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface UserMapperConfig {
    void mapUser(User user, @MappingTarget UserDto userDto);
}
