package xyz.walk8243.athleticstool.entity.domain.response;

import java.util.Optional;

import jakarta.annotation.Nonnull;

public record PlayerResponse(
	@Nonnull Integer id,
	@Nonnull String name,
	@Nonnull String kana,
	Optional<PlayerBelong> belong
) {

	public record PlayerBelong(
		@Nonnull Integer id,
		@Nonnull String name
	) {}
}
