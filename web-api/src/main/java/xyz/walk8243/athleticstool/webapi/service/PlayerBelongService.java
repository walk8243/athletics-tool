package xyz.walk8243.athleticstool.webapi.service;

import io.micrometer.common.lang.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerBelongListResponse;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerBelongResponse;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerListResponse;
import xyz.walk8243.athleticstool.webapi.domain.response.PlayerBelongDetailResponse;
import xyz.walk8243.athleticstool.webapi.infrastructure.repository.PlayerBelongRepository;
import xyz.walk8243.athleticstool.webapi.infrastructure.repository.PlayerRepository;

@Service
@RequiredArgsConstructor
public class PlayerBelongService {
	private final PlayerBelongRepository playerBelongRepository;
	private final PlayerRepository playerRepository;

	public PlayerBelongListResponse top() {
		return playerBelongRepository.list();
	}

	public PlayerBelongDetailResponse detail(@NonNull Integer belongId) {
		final PlayerBelongResponse playerBelongResponse = playerBelongRepository.get(belongId);
		final PlayerListResponse playerListResponse = playerRepository.listByBelongId(belongId);

		return new PlayerBelongDetailResponse(playerBelongResponse, playerListResponse.players());
	}
}
