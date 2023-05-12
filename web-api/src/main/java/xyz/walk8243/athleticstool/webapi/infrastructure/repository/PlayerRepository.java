package xyz.walk8243.athleticstool.webapi.infrastructure.repository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerListResponse;

@Repository
@RequiredArgsConstructor
public class PlayerRepository {
	private final RestTemplate restTemplate;
	
	public PlayerListResponse list() {
		final ResponseEntity<PlayerListResponse> response =
				restTemplate.getForEntity("/player/list", PlayerListResponse.class);
		return response.getBody();
	}
}
