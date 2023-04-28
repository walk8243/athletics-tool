package xyz.walk8243.athleticstool.repositoryapi.domain.translator;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Component;

import jakarta.annotation.Nonnull;
import lombok.NonNull;
import xyz.walk8243.athleticstool.repositoryapi.domain.record.PlayerFullRecord;
import xyz.walk8243.athleticstool.repositoryapi.domain.response.PlayerListResponse;
import xyz.walk8243.athleticstool.repositoryapi.domain.response.PlayerResponse;
import xyz.walk8243.athleticstool.repositoryapi.domain.response.PlayerResponse.PlayerBelong;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerBelongRecord;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerRecord;

@Component
public class PlayerTranslator {
	
	public PlayerListResponse translate(@NonNull Map<PlayerRecord, List<PlayerFullRecord>> resultMap) {
		return new PlayerListResponse(
			resultMap.entrySet().stream()
				.map(entry -> translatePlayer(entry.getKey(), entry.getValue()))
				.filter(Optional::isPresent)
				.map(Optional::get)
				.toList()
		);
	}

	private Optional<PlayerResponse> translatePlayer(@Nonnull PlayerRecord player, @Nonnull List<PlayerFullRecord> fullRecords) {
		final Optional<PlayerFullRecord> fullRecordOptional = fullRecords.stream().findFirst();
		if (fullRecordOptional.isEmpty()) {
			return Optional.empty();
		}

		return fullRecordOptional
			.map(fullRecord -> new PlayerResponse(player.getId(), fullRecord.historyRecord().getName(), fullRecord.historyRecord().getKana(), translatePlayerBelong(fullRecord.belongRecord())));
	}

	private Optional<PlayerBelong> translatePlayerBelong(@Nonnull PlayerBelongRecord playerBelongRecord) {
		if (Objects.isNull(playerBelongRecord.getId()) || playerBelongRecord.getDeleteFlag().equals(Byte.valueOf("1"))) {
			return Optional.empty();
		}

		return Optional.of(new PlayerBelong(playerBelongRecord.getId(), playerBelongRecord.getName()));
	}
}
