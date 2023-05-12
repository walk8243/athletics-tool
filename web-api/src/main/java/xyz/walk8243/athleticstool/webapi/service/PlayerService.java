package xyz.walk8243.athleticstool.webapi.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerListResponse;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerResponse;
import xyz.walk8243.athleticstool.webapi.infrastructure.repository.PlayerRepository;

@Service
@RequiredArgsConstructor
public class PlayerService {
	private final PlayerRepository repository;

	public PlayerListResponse list() {
		return repository.list();
	}

	public PlayerResponse detail(@NonNull Integer playerId) {
		return repository.get(playerId);
	}
}
