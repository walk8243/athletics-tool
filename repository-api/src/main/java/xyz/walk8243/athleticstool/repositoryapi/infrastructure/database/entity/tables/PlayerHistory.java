/*
 * This file is generated by jOOQ.
 */
package xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function8;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.AthleticsTool;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.Keys;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerHistoryRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PlayerHistory extends TableImpl<PlayerHistoryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>athletics-tool.player_history</code>
     */
    public static final PlayerHistory PLAYER_HISTORY = new PlayerHistory();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PlayerHistoryRecord> getRecordType() {
        return PlayerHistoryRecord.class;
    }

    /**
     * The column <code>athletics-tool.player_history.id</code>.
     */
    public final TableField<PlayerHistoryRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>athletics-tool.player_history.player_id</code>.
     */
    public final TableField<PlayerHistoryRecord, Integer> PLAYER_ID = createField(DSL.name("player_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>athletics-tool.player_history.history</code>.
     */
    public final TableField<PlayerHistoryRecord, Integer> HISTORY = createField(DSL.name("history"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field("1", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>athletics-tool.player_history.belong_id</code>.
     */
    public final TableField<PlayerHistoryRecord, Integer> BELONG_ID = createField(DSL.name("belong_id"), SQLDataType.INTEGER.defaultValue(DSL.field("NULL", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>athletics-tool.player_history.name</code>.
     */
    public final TableField<PlayerHistoryRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>athletics-tool.player_history.kana</code>.
     */
    public final TableField<PlayerHistoryRecord, String> KANA = createField(DSL.name("kana"), SQLDataType.VARCHAR(255).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>athletics-tool.player_history.year</code>.
     */
    public final TableField<PlayerHistoryRecord, Integer> YEAR = createField(DSL.name("year"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>athletics-tool.player_history.created_at</code>.
     */
    public final TableField<PlayerHistoryRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(0).defaultValue(DSL.field("current_timestamp()", SQLDataType.LOCALDATETIME)), this, "");

    private PlayerHistory(Name alias, Table<PlayerHistoryRecord> aliased) {
        this(alias, aliased, null);
    }

    private PlayerHistory(Name alias, Table<PlayerHistoryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>athletics-tool.player_history</code> table
     * reference
     */
    public PlayerHistory(String alias) {
        this(DSL.name(alias), PLAYER_HISTORY);
    }

    /**
     * Create an aliased <code>athletics-tool.player_history</code> table
     * reference
     */
    public PlayerHistory(Name alias) {
        this(alias, PLAYER_HISTORY);
    }

    /**
     * Create a <code>athletics-tool.player_history</code> table reference
     */
    public PlayerHistory() {
        this(DSL.name("player_history"), null);
    }

    public <O extends Record> PlayerHistory(Table<O> child, ForeignKey<O, PlayerHistoryRecord> key) {
        super(child, key, PLAYER_HISTORY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : AthleticsTool.ATHLETICS_TOOL;
    }

    @Override
    public Identity<PlayerHistoryRecord, Integer> getIdentity() {
        return (Identity<PlayerHistoryRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<PlayerHistoryRecord> getPrimaryKey() {
        return Keys.KEY_PLAYER_HISTORY_PRIMARY;
    }

    @Override
    public List<UniqueKey<PlayerHistoryRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_PLAYER_HISTORY_PLAYER_HISTORY_UK);
    }

    @Override
    public List<ForeignKey<PlayerHistoryRecord, ?>> getReferences() {
        return Arrays.asList(Keys.PLAYER_HISTORY_PLAYER_FK, Keys.PLAYER_BELONG_FK);
    }

    private transient Player _player;
    private transient PlayerBelong _playerBelong;

    /**
     * Get the implicit join path to the <code>athletics-tool.player</code>
     * table.
     */
    public Player player() {
        if (_player == null)
            _player = new Player(this, Keys.PLAYER_HISTORY_PLAYER_FK);

        return _player;
    }

    /**
     * Get the implicit join path to the
     * <code>athletics-tool.player_belong</code> table.
     */
    public PlayerBelong playerBelong() {
        if (_playerBelong == null)
            _playerBelong = new PlayerBelong(this, Keys.PLAYER_BELONG_FK);

        return _playerBelong;
    }

    @Override
    public PlayerHistory as(String alias) {
        return new PlayerHistory(DSL.name(alias), this);
    }

    @Override
    public PlayerHistory as(Name alias) {
        return new PlayerHistory(alias, this);
    }

    @Override
    public PlayerHistory as(Table<?> alias) {
        return new PlayerHistory(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public PlayerHistory rename(String name) {
        return new PlayerHistory(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PlayerHistory rename(Name name) {
        return new PlayerHistory(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public PlayerHistory rename(Table<?> name) {
        return new PlayerHistory(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Integer, Integer, Integer, Integer, String, String, Integer, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function8<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super String, ? super String, ? super Integer, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function8<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super String, ? super String, ? super Integer, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
