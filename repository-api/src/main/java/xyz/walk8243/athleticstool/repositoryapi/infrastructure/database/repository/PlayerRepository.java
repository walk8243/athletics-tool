package xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
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

	public Optional<PlayerFullRecord> get(@NonNull Integer playerId) {
		return dslContext
				.select()
				.from(Player.PLAYER)
				.join(PlayerHistory.PLAYER_HISTORY)
				.onKey(Keys.PLAYER_HISTORY_PLAYER_FK)
				.leftJoin(PlayerBelong.PLAYER_BELONG)
				.onKey(Keys.PLAYER_BELONG_FK)
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

	public Map<PlayerRecord, List<PlayerFullRecord>> list() {
		return dslContext
				.select()
				.from(Player.PLAYER)
				.join(PlayerHistory.PLAYER_HISTORY)
				.onKey(Keys.PLAYER_HISTORY_PLAYER_FK)
				.leftJoin(PlayerBelong.PLAYER_BELONG)
				.onKey(Keys.PLAYER_BELONG_FK)
				.orderBy(Player.PLAYER.ID, PlayerHistory.PLAYER_HISTORY.HISTORY.desc())
				.fetchGroups(
						record -> record.into(Player.PLAYER),
						record ->
								new PlayerFullRecord(
										record.into(Player.PLAYER),
										record.into(PlayerHistory.PLAYER_HISTORY),
										record.into(PlayerBelong.PLAYER_BELONG)));
	}
}
