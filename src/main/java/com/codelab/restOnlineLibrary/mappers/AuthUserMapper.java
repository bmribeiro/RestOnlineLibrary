package com.codelab.restOnlineLibrary.mappers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codelab.restOnlineLibrary.dto.AuthUserDTO;
import com.codelab.restOnlineLibrary.entities.AuthUser;
import com.codelab.restOnlineLibrary.entities.Reservation;
import com.codelab.restOnlineLibrary.repositories.ReservationRepository;

@Component
public class AuthUserMapper {

	@Autowired
	private ReservationMapper reservationMapper;

	@Autowired
	private ReservationRepository reservationRepository;

	public AuthUserDTO toDTO(AuthUser authUser) {
		AuthUserDTO authUserDTO = new AuthUserDTO();
		authUserDTO.setId(authUser.getId());
		authUserDTO.setFirstName(authUser.getFirstName());
		authUserDTO.setLastName(authUser.getLastName());
		authUserDTO.setEmail(authUser.getEmail());
		authUserDTO.setProfile(authUser.getProfile());
		authUserDTO.setCreated(authUser.getCreated());
		authUserDTO.setActive(authUser.isActive());

		authUserDTO.setReservations(
				authUser.getReservations().stream().map(reservationMapper::ToDTO).collect(Collectors.toList()));
		return authUserDTO;
	}

	public AuthUser toEntity(AuthUserDTO authUserDTO) {
		AuthUser authUser = new AuthUser();
		authUser.setId(authUserDTO.getId());
		authUser.setFirstName(authUserDTO.getFirstName());
		authUser.setLastName(authUserDTO.getLastName());
		authUser.setEmail(authUserDTO.getEmail());
		authUser.setProfile(authUserDTO.getProfile());
		authUser.setCreated(authUserDTO.getCreated());
		authUser.setActive(authUserDTO.isActive());

		// To Reservation Entity
		List<Reservation> reservations = authUserDTO.getReservations().stream().map(reservationDTO -> {

			Optional<Reservation> reservation = reservationRepository.findById(reservationDTO.getId());
			return reservation.orElseThrow(() -> new RuntimeException("Reservation not found"));

		}).collect(Collectors.toList());

		authUser.setReservations(reservations);

		return authUser;
	}
}