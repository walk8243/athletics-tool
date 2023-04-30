package xyz.walk8243.athleticstool.repositoryapi.domain.record;

import jakarta.annotation.Nonnull;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerBelongRecord;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerHistoryRecord;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerRecord;

public record PlayerFullRecord(
		@Nonnull PlayerRecord playerRecord,
		@Nonnull PlayerHistoryRecord historyRecord,
		@Nonnull PlayerBelongRecord belongRecord) {}
