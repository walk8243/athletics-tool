package xyz.walk8243.athleticstool.entity.domain.response;

import jakarta.annotation.Nonnull;
import java.util.List;

public record PlayerListResponse(@Nonnull List<PlayerResponse> players) {}
