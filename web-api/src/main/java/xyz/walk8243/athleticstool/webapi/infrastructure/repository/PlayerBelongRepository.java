package xyz.walk8243.athleticstool.webapi.infrastructure.repository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerBelongListResponse;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerBelongResponse;

@Repository
@RequiredArgsConstructor
public class PlayerBelongRepository {
	private final RestTemplate restTemplate;

	public PlayerBelongListResponse list() {
		final ResponseEntity<PlayerBelongListResponse> response =
				restTemplate.getForEntity("/playerbelong/list", PlayerBelongListResponse.class);
		return response.getBody();
	}

	public PlayerBelongResponse get(@NonNull Integer belongId) {
		final ResponseEntity<PlayerBelongResponse> response =
				restTemplate.getForEntity(
						"/playerbelong/%d".formatted(belongId), PlayerBelongResponse.class);
		return response.getBody();
	}
}
