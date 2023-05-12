package xyz.walk8243.athleticstool.webapi.infrastructure.repository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerListResponse;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerResponse;

@Repository
@RequiredArgsConstructor
public class PlayerRepository {
	private final RestTemplate restTemplate;

	public PlayerListResponse list() {
		final ResponseEntity<PlayerListResponse> response =
				restTemplate.getForEntity("/player/list", PlayerListResponse.class);
		return response.getBody();
	}

	public PlayerResponse get(@NonNull Integer playerId) {
		final ResponseEntity<PlayerResponse> response =
				restTemplate.getForEntity("/player/%d".formatted(playerId), PlayerResponse.class);
		return response.getBody();
	}

	public PlayerListResponse listByBelongId(@NonNull Integer belongId) {
		final ResponseEntity<PlayerListResponse> response =
				restTemplate.getForEntity(
						"/player/belong/%d".formatted(belongId), PlayerListResponse.class);
		return response.getBody();
	}
}
