package xyz.walk8243.athleticstool.webapi.service.async;

import jakarta.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerBelongResponse;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerListResponse;
import xyz.walk8243.athleticstool.webapi.infrastructure.repository.PlayerBelongRepository;
import xyz.walk8243.athleticstool.webapi.infrastructure.repository.PlayerRepository;

@Component
@RequiredArgsConstructor
public class PlayerBelongDetailAsync {
	private final PlayerBelongRepository playerBelongRepository;
	private final PlayerRepository playerRepository;

	public Result async(@Nonnull Integer belongId) {
		final CompletableFuture<PlayerBelongResponse> playerBelongResponseFuture =
				CompletableFuture.supplyAsync(() -> playerBelongRepository.get(belongId));
		final CompletableFuture<PlayerListResponse> playerListResponseFuture =
				CompletableFuture.supplyAsync(() -> playerRepository.listByBelongId(belongId))
						.exceptionally((ex) -> new PlayerListResponse());

		return new Result(playerBelongResponseFuture.join(), playerListResponseFuture.join());
	}

	public record Result(
			PlayerBelongResponse playerBelongResponse, PlayerListResponse playerListResponse) {}
}
