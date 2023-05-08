package xyz.walk8243.athleticstool.repositoryapi.service;

import java.util.Map;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.walk8243.athleticstool.entity.domain.exception.NoDataException;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerListResponse;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerResponse;
import xyz.walk8243.athleticstool.repositoryapi.domain.record.PlayerFullRecord;
import xyz.walk8243.athleticstool.repositoryapi.domain.translator.PlayerTranslator;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerRecord;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.repository.PlayerRepository;

@Service
@RequiredArgsConstructor
public class PlayerService {
	private final PlayerRepository repository;
	private final PlayerTranslator translator;

	public PlayerResponse get(@NonNull Integer playerId) {
		final Optional<PlayerFullRecord> player = repository.get(playerId);
		if (player.isEmpty()) {
			throw new NoDataException("playerId: %d".formatted(playerId));
		}

		return translator.translate(player.get());
	}

	public PlayerListResponse list() {
		final Map<PlayerRecord, PlayerFullRecord> resultMap = repository.list();

		return translator.translate(resultMap);
	}

	public PlayerListResponse belong(@NonNull Integer belongId) {
		final Map<PlayerRecord, PlayerFullRecord> resultMap = repository.belong(belongId);

		return translator.translate(resultMap);
	}
}
