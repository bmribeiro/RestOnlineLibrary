package com.codelab.restOnlineLibrary.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.codelab.restOnlineLibrary.dto.SignUpDto;
import com.codelab.restOnlineLibrary.dto.UserDto;
import com.codelab.restOnlineLibrary.entities.AuthUser;

@Mapper(componentModel = "spring")
public interface AuthUserMapper {
	
	UserDto toUserDto(AuthUser user);
	
	@Mapping(target = "password", ignore = true)
	AuthUser signUpToUser(SignUpDto signUpDto);

}
