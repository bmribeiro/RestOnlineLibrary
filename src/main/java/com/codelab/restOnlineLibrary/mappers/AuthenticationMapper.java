package com.codelab.restOnlineLibrary.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.codelab.restOnlineLibrary.dto.AuthUserDTO;
import com.codelab.restOnlineLibrary.dto.RegisterDTO;
import com.codelab.restOnlineLibrary.entities.AuthUser;

@Mapper(componentModel = "spring")
public interface AuthenticationMapper {

	AuthUserDTO toDTO(AuthUser user);

	@Mapping(target = "password", ignore = true)
	AuthUser toEntity(RegisterDTO registerDTO);

}
