package xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.repository;

import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.SQLDataType;
import org.springframework.stereotype.Repository;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.PlayerBelong;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerBelongRecord;

@Repository
@RequiredArgsConstructor
public class PlayerBelongRepository {
	private final DSLContext dslContext;
	private static final Byte SQL_FALSE_VALUE = SQLDataType.TINYINT.convert(Boolean.FALSE);

	public Optional<PlayerBelongRecord> get(@NonNull Integer belongId) {
		final PlayerBelong playerBelong = PlayerBelong.PLAYER_BELONG;

		return dslContext
				.select()
				.from(playerBelong)
				.where(playerBelong.ID.eq(belongId))
				.and(playerBelong.DELETE_FLAG.eq(SQL_FALSE_VALUE))
				.limit(1)
				.fetchOptionalInto(playerBelong);
	}

	public List<PlayerBelongRecord> list() {
		final PlayerBelong playerBelong = PlayerBelong.PLAYER_BELONG;

		return dslContext
				.select()
				.from(playerBelong)
				.where(playerBelong.DELETE_FLAG.eq(SQL_FALSE_VALUE))
				.orderBy(playerBelong.ID)
				.fetchInto(playerBelong);
	}
}
