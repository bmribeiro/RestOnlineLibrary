package com.codelab.restOnlineLibrary.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelab.restOnlineLibrary.dto.UserInMemoryDTO;
import com.codelab.restOnlineLibrary.entities.UserInMemory;
import com.codelab.restOnlineLibrary.mappers.UserInMemoryMapper;
import com.codelab.restOnlineLibrary.repositories.UserInMemoryRepository;

@Service
public class UserInMemoryService {

	@Autowired
	private UserInMemoryRepository userAppRepository;

	@Autowired
	private UserInMemoryMapper userInMemoryMapper;

	public List<UserInMemoryDTO> findAll() {

		List<UserInMemory> users = userAppRepository.findAll();
		return users.stream().map(userInMemoryMapper::toDTO).collect(Collectors.toList());
	}

	public Optional<UserInMemoryDTO> findById(Long id) {

		Optional<UserInMemory> user = userAppRepository.findById(id);
		return user.map(userInMemoryMapper::toDTO);
	}

	public UserInMemoryDTO save(UserInMemoryDTO userDTO) {

		UserInMemory user = userInMemoryMapper.toEntity(userDTO);
		return userInMemoryMapper.toDTO(userAppRepository.save(user));
	}

	public boolean deleteById(Long id) {

		if (userAppRepository.existsById(id)) {
			userAppRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}