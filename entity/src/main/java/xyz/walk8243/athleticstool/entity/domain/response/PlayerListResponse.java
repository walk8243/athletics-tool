package xyz.walk8243.athleticstool.entity.domain.response;

import java.util.List;

import jakarta.annotation.Nonnull;

public record PlayerListResponse(@Nonnull List<PlayerResponse> players) {}
