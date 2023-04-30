/*
 * This file is generated by jOOQ.
 */
package xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.Player;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.PlayerBelong;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.PlayerHistory;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerBelongRecord;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerHistoryRecord;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerRecord;

/** A class modelling foreign key relationships and constraints of tables in athletics-tool. */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Keys {

	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final UniqueKey<PlayerRecord> KEY_PLAYER_PRIMARY =
			Internal.createUniqueKey(
					Player.PLAYER, DSL.name("KEY_player_PRIMARY"), new TableField[] {Player.PLAYER.ID}, true);
	public static final UniqueKey<PlayerBelongRecord> KEY_PLAYER_BELONG_PRIMARY =
			Internal.createUniqueKey(
					PlayerBelong.PLAYER_BELONG,
					DSL.name("KEY_player_belong_PRIMARY"),
					new TableField[] {PlayerBelong.PLAYER_BELONG.ID},
					true);
	public static final UniqueKey<PlayerHistoryRecord> KEY_PLAYER_HISTORY_PLAYER_HISTORY_UK =
			Internal.createUniqueKey(
					PlayerHistory.PLAYER_HISTORY,
					DSL.name("KEY_player_history_player_history_uk"),
					new TableField[] {
						PlayerHistory.PLAYER_HISTORY.PLAYER_ID, PlayerHistory.PLAYER_HISTORY.HISTORY
					},
					true);
	public static final UniqueKey<PlayerHistoryRecord> KEY_PLAYER_HISTORY_PRIMARY =
			Internal.createUniqueKey(
					PlayerHistory.PLAYER_HISTORY,
					DSL.name("KEY_player_history_PRIMARY"),
					new TableField[] {PlayerHistory.PLAYER_HISTORY.ID},
					true);

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------

	public static final ForeignKey<PlayerHistoryRecord, PlayerBelongRecord> PLAYER_BELONG_FK =
			Internal.createForeignKey(
					PlayerHistory.PLAYER_HISTORY,
					DSL.name("player_belong_fk"),
					new TableField[] {PlayerHistory.PLAYER_HISTORY.BELONG_ID},
					Keys.KEY_PLAYER_BELONG_PRIMARY,
					new TableField[] {PlayerBelong.PLAYER_BELONG.ID},
					true);
	public static final ForeignKey<PlayerHistoryRecord, PlayerRecord> PLAYER_HISTORY_PLAYER_FK =
			Internal.createForeignKey(
					PlayerHistory.PLAYER_HISTORY,
					DSL.name("player_history_player_fk"),
					new TableField[] {PlayerHistory.PLAYER_HISTORY.PLAYER_ID},
					Keys.KEY_PLAYER_PRIMARY,
					new TableField[] {Player.PLAYER.ID},
					true);
}
