package xyz.walk8243.athleticstool.repositoryapi.domain.translator;

import jakarta.annotation.Nonnull;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerListResponse;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerResponse;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerResponse.PlayerBelong;
import xyz.walk8243.athleticstool.repositoryapi.domain.record.PlayerFullRecord;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerBelongRecord;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerRecord;

@Component
public class PlayerTranslator {

	public PlayerResponse translate(@NonNull PlayerFullRecord fullRecord) {
		return new PlayerResponse(
				fullRecord.playerRecord().getId(),
				fullRecord.historyRecord().getName(),
				fullRecord.historyRecord().getKana(),
				translatePlayerBelong(fullRecord.belongRecord()));
	}

	public PlayerListResponse translate(@NonNull Map<PlayerRecord, PlayerFullRecord> resultMap) {
		return new PlayerListResponse(resultMap.values().stream().map(this::translate).toList());
	}

	private Optional<PlayerBelong> translatePlayerBelong(
			@Nonnull PlayerBelongRecord playerBelongRecord) {
		if (Objects.isNull(playerBelongRecord.getId())) {
			return Optional.empty();
		}

		return Optional.of(new PlayerBelong(playerBelongRecord.getId(), playerBelongRecord.getName()));
	}
}
