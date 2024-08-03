package com.codelab.restOnlineLibrary.mappers;

import org.mapstruct.Mapper;

import com.codelab.restOnlineLibrary.dto.UserInMemoryDTO;
import com.codelab.restOnlineLibrary.entities.UserInMemory;

@Mapper(componentModel = "spring")
public interface UserInMemoryMapper {

	UserInMemoryDTO toDTO(UserInMemory user);

	UserInMemory toEntity(UserInMemoryDTO user);
}
