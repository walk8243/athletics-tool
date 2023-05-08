package xyz.walk8243.athleticstool.entity.domain.response;

import jakarta.annotation.Nonnull;
import java.util.Optional;

public record PlayerResponse(
		@Nonnull Integer id,
		@Nonnull String name,
		@Nonnull String kana,
		Optional<PlayerBelong> belong) {

	public record PlayerBelong(@Nonnull Integer id, @Nonnull String name) {}
}
