package xyz.walk8243.athleticstool.toolapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerListResponse;
import xyz.walk8243.athleticstool.toolapi.infrastructure.repository.PlayerRepository;

@Service
@RequiredArgsConstructor
public class PlayerService {
	private final PlayerRepository repository;

	public PlayerListResponse list() {
		return repository.list();
	}
}
