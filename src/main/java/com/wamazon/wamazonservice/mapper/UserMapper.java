package com.wamazon.wamazonservice.mapper;

import com.wamazon.wamazonservice.dto.UserDto;
import com.wamazon.wamazonservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements EntityMapper<User, UserDto> {

    public abstract User mapToEntity(UserDto dto);

    public abstract UserDto mapToDto(User entity);

}
