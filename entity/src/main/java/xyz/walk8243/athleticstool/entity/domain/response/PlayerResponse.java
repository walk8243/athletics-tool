package xyz.walk8243.athleticstool.entity.domain.response;

import jakarta.annotation.Nonnull;
import java.util.Optional;

public record PlayerResponse(
		@Nonnull Integer id,
		@Nonnull String name,
		@Nonnull String kana,
		@Nonnull Prefecture prefecture,
		@Nonnull Category category,
		Optional<PlayerBelong> belong) {

	public enum Prefecture {
		hokkaido,
		saitama,
		tokyo
	}

	public enum Category {
		senior,
		ordinary
	}

	public record PlayerBelong(@Nonnull Integer id, @Nonnull String name) {}
}
