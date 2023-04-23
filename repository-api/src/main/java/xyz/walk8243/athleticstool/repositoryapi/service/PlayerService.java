package xyz.walk8243.athleticstool.repositoryapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerRecord;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.repository.PlayerRepository;

@Service
@RequiredArgsConstructor
public class PlayerService {
	private final PlayerRepository repository;

	public List<PlayerRecord> list() {
		return repository.list();
	}
}
