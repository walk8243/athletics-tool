package xyz.walk8243.athleticstool.entity.domain.response;

import jakarta.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public record PlayerBelongListResponse(@Nonnull List<PlayerBelongResponse> list) {
	public PlayerBelongListResponse() {
		this(new ArrayList<>());
	}
}
