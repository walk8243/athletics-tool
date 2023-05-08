package xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.repository;

import java.util.Map;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.springframework.stereotype.Repository;
import xyz.walk8243.athleticstool.repositoryapi.domain.record.PlayerFullRecord;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.Keys;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.Player;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.PlayerBelong;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.PlayerHistory;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerRecord;

@Repository
@RequiredArgsConstructor
public class PlayerRepository {
	private final DSLContext dslContext;
	private static final Byte SQL_FALSE_VALUE = SQLDataType.TINYINT.convert(Boolean.FALSE);

	public Optional<PlayerFullRecord> get(@NonNull Integer playerId) {
		return dslContext
				.select()
				.from(Player.PLAYER)
				.join(PlayerHistory.PLAYER_HISTORY)
				.onKey(Keys.PLAYER_HISTORY_PLAYER_FK)
				.leftJoin(PlayerBelong.PLAYER_BELONG)
				.onKey(Keys.PLAYER_BELONG_FK)
				.and(PlayerBelong.PLAYER_BELONG.DELETE_FLAG.eq(SQL_FALSE_VALUE))
				.where(Player.PLAYER.ID.eq(playerId))
				.orderBy(PlayerHistory.PLAYER_HISTORY.HISTORY.desc())
				.limit(1)
				.fetchOptional(
						record ->
								new PlayerFullRecord(
										record.into(Player.PLAYER),
										record.into(PlayerHistory.PLAYER_HISTORY),
										record.into(PlayerBelong.PLAYER_BELONG)));
	}

	public Map<PlayerRecord, PlayerFullRecord> list() {
		final Table<Record2<Integer, Integer>> maxHistoryPlayerTable = createMaxHistoryPlayerTable();

		return dslContext
				.select()
				.from(Player.PLAYER)
				.join(PlayerHistory.PLAYER_HISTORY)
				.onKey(Keys.PLAYER_HISTORY_PLAYER_FK)
				.join(maxHistoryPlayerTable)
				.on(
						Player.PLAYER.ID.eq(maxHistoryPlayerTable.field(0, Integer.class)),
						PlayerHistory.PLAYER_HISTORY.HISTORY.eq(maxHistoryPlayerTable.field(1, Integer.class)))
				.leftJoin(PlayerBelong.PLAYER_BELONG)
				.onKey(Keys.PLAYER_BELONG_FK)
				.and(PlayerBelong.PLAYER_BELONG.DELETE_FLAG.eq(SQL_FALSE_VALUE))
				.orderBy(Player.PLAYER.ID, PlayerHistory.PLAYER_HISTORY.HISTORY.desc())
				.fetchMap(
						record -> record.into(Player.PLAYER),
						record ->
								new PlayerFullRecord(
										record.into(Player.PLAYER),
										record.into(PlayerHistory.PLAYER_HISTORY),
										record.into(PlayerBelong.PLAYER_BELONG)));
	}

	public Map<PlayerRecord, PlayerFullRecord> belong(@NonNull Integer belongId) {
		final Table<Record2<Integer, Integer>> maxHistoryPlayerTable = createMaxHistoryPlayerTable();

		return dslContext
				.select()
				.from(Player.PLAYER)
				.join(PlayerHistory.PLAYER_HISTORY)
				.onKey(Keys.PLAYER_HISTORY_PLAYER_FK)
				.join(maxHistoryPlayerTable)
				.on(
						Player.PLAYER.ID.eq(maxHistoryPlayerTable.field(0, Integer.class)),
						PlayerHistory.PLAYER_HISTORY.HISTORY.eq(maxHistoryPlayerTable.field(1, Integer.class)))
				.leftJoin(PlayerBelong.PLAYER_BELONG)
				.onKey(Keys.PLAYER_BELONG_FK)
				.and(PlayerBelong.PLAYER_BELONG.DELETE_FLAG.eq(SQL_FALSE_VALUE))
				.where(PlayerBelong.PLAYER_BELONG.ID.eq(belongId))
				.fetchMap(
						record -> record.into(Player.PLAYER),
						record ->
								new PlayerFullRecord(
										record.into(Player.PLAYER),
										record.into(PlayerHistory.PLAYER_HISTORY),
										record.into(PlayerBelong.PLAYER_BELONG)));
	}

	private Table<Record2<Integer, Integer>> createMaxHistoryPlayerTable() {
		return dslContext
				.select(
						PlayerHistory.PLAYER_HISTORY.PLAYER_ID.as("player_id"),
						DSL.max(PlayerHistory.PLAYER_HISTORY.HISTORY).as("max_no"))
				.from(PlayerHistory.PLAYER_HISTORY)
				.groupBy(PlayerHistory.PLAYER_HISTORY.PLAYER_ID)
				.asTable();
	}
}
