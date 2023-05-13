package xyz.walk8243.athleticstool.webapi.domain.response;

import jakarta.annotation.Nonnull;
import java.util.List;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerBelongResponse;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerResponse;

public record PlayerBelongDetailResponse(
		@Nonnull PlayerBelongResponse belong, @Nonnull List<Player> players) {

	public record Player(
			@Nonnull Integer id, @Nonnull String name, @Nonnull PlayerResponse.Category category) {}
}
