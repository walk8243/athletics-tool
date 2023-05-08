package xyz.walk8243.athleticstool.repositoryapi.service;

import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.walk8243.athleticstool.entity.domain.exception.NoDataException;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerBelongListResponse;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerBelongResponse;
import xyz.walk8243.athleticstool.repositoryapi.domain.translator.PlayerBelongTranslator;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerBelongRecord;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.repository.PlayerBelongRepository;

@Service
@RequiredArgsConstructor
public class PlayerBelongService {
	private final PlayerBelongRepository repository;
	private final PlayerBelongTranslator translator;

	public PlayerBelongResponse get(@NonNull Integer belongId) {
		final Optional<PlayerBelongRecord> record = repository.get(belongId);
		if (record.isEmpty()) {
			throw new NoDataException("belongId: %d".formatted(belongId));
		}

		return translator.translate(record.get());
	}

	public PlayerBelongListResponse list() {
		final List<PlayerBelongRecord> records = repository.list();

		return translator.translate(records);
	}
}
