package xyz.walk8243.athleticstool.repositoryapi.domain.translator;

import java.util.List;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerBelongListResponse;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerBelongResponse;
import xyz.walk8243.athleticstool.repositoryapi.infrastructure.database.entity.tables.records.PlayerBelongRecord;

@Component
public class PlayerBelongTranslator {

	public PlayerBelongResponse translate(@NonNull PlayerBelongRecord record) {
		return new PlayerBelongResponse(record.getId(), record.getName());
	}

	public PlayerBelongListResponse translate(@NonNull List<PlayerBelongRecord> records) {
		return new PlayerBelongListResponse(records.stream().map(this::translate).toList());
	}
}
