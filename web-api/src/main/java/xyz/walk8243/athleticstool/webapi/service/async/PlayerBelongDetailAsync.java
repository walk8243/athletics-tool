package xyz.walk8243.athleticstool.webapi.service.async;

import jakarta.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import xyz.walk8243.athleticstool.entity.domain.exception.NoDataException;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerBelongResponse;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerListResponse;
import xyz.walk8243.athleticstool.webapi.infrastructure.repository.PlayerBelongRepository;
import xyz.walk8243.athleticstool.webapi.infrastructure.repository.PlayerRepository;

@Slf4j
@Component
@RequiredArgsConstructor
public class PlayerBelongDetailAsync {
	private final PlayerBelongRepository playerBelongRepository;
	private final PlayerRepository playerRepository;

	public Result async(@Nonnull Integer belongId) {
		final CompletableFuture<PlayerBelongResponse> playerBelongResponseFuture =
				CompletableFuture.supplyAsync(
						() -> {
							try {
								return playerBelongRepository.get(belongId);
							} catch (RestClientException e) {
								log.debug(e.getMessage());
								throw new NoDataException(
										"[playerBelongRepository.get]belongId:%d".formatted(belongId));
							}
						});
		final CompletableFuture<PlayerListResponse> playerListResponseFuture =
				CompletableFuture.supplyAsync(() -> playerRepository.listByBelongId(belongId));

		return new Result(playerBelongResponseFuture.join(), playerListResponseFuture.join());
	}

	public record Result(
			PlayerBelongResponse playerBelongResponse, PlayerListResponse playerListResponse) {}
}
