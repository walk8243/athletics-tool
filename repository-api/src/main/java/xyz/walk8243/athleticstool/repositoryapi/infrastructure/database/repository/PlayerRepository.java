package xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.repository;

import java.util.List;
import java.util.Map;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
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
				record -> new PlayerFullRecord(record.into(Player.PLAYER), record.into(PlayerHistory.PLAYER_HISTORY), record.into(PlayerBelong.PLAYER_BELONG))
			);
	}
}
