package xyz.walk8243.athleticstool.repositoryapi.domain.response;

import java.util.List;

import jakarta.annotation.Nonnull;

public record PlayerListResponse(@Nonnull List<PlayerResponse> players) {}
