package xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.repository;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.Player;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerRecord;

@Repository
@RequiredArgsConstructor
public class PlayerRepository {
	private final DSLContext dslContext;

	public Result<PlayerRecord> list() {
		return dslContext
			.selectFrom(Player.PLAYER)
			.fetchInto(Player.PLAYER);
	}
}
