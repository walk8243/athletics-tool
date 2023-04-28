package xyz.walk8243.athleticstool.repositoryapi.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.walk8243.athleticstool.repositoryapi.domain.record.PlayerFullRecord;
import xyz.walk8243.athleticstool.repositoryapi.domain.response.PlayerListResponse;
import xyz.walk8243.athleticstool.repositoryapi.domain.translator.PlayerTranslator;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerRecord;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.repository.PlayerRepository;

@Service
@RequiredArgsConstructor
public class PlayerService {
	private final PlayerRepository repository;
	private final PlayerTranslator translator;

	public PlayerListResponse list() {
		final Map<PlayerRecord, List<PlayerFullRecord>> resultMap = repository.list();

		return translator.translate(resultMap);
	}
}
