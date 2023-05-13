package xyz.walk8243.athleticstool.webapi.domain.translator;

import jakarta.annotation.Nonnull;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerResponse;
import xyz.walk8243.athleticstool.webapi.domain.response.PlayerBelongDetailResponse;
import xyz.walk8243.athleticstool.webapi.service.async.PlayerBelongDetailAsync;

@Component
public class PlayerBelongDetailTranslator {

	public PlayerBelongDetailResponse translate(@NonNull PlayerBelongDetailAsync.Result result) {
		return new PlayerBelongDetailResponse(
				result.playerBelongResponse(),
				result.playerListResponse().players().stream().map(this::translatePlayer).toList());
	}

	private PlayerBelongDetailResponse.Player translatePlayer(@Nonnull PlayerResponse player) {
		return new PlayerBelongDetailResponse.Player(player.id(), player.name(), player.category());
	}
}
