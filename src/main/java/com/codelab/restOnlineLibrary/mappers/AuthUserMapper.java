package com.codelab.restOnlineLibrary.mappers;

import org.springframework.stereotype.Component;

import com.codelab.restOnlineLibrary.dto.views.user.UserViewDTO;
import com.codelab.restOnlineLibrary.entities.AuthUser;

@Component
public class AuthUserMapper {

    public UserViewDTO toDTO(AuthUser authUser) {
        return new UserViewDTO.Builder()
            .setId(authUser.getId())
            .setUsername(authUser.getUsername())
            .setEmail(authUser.getEmail())
            .setRole(authUser.getRole())
            .setUserStatus(authUser.isUserStatus())
            .setCreatedAt(authUser.getCreatedAt())
            .setUserStatusChangedAt(authUser.getUserStatusChangedAt())
            .build();
    }
}