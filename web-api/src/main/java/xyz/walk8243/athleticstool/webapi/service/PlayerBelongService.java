package xyz.walk8243.athleticstool.webapi.service;

import io.micrometer.common.lang.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerBelongListResponse;
import xyz.walk8243.athleticstool.webapi.domain.response.PlayerBelongDetailResponse;
import xyz.walk8243.athleticstool.webapi.domain.translator.PlayerBelongDetailTranslator;
import xyz.walk8243.athleticstool.webapi.infrastructure.repository.PlayerBelongRepository;
import xyz.walk8243.athleticstool.webapi.service.async.PlayerBelongDetailAsync;

@Service
@RequiredArgsConstructor
public class PlayerBelongService {
	private final PlayerBelongRepository playerBelongRepository;
	private final PlayerBelongDetailAsync playerBelongDetailAsync;
	private final PlayerBelongDetailTranslator detailTranslator;

	public PlayerBelongListResponse top() {
		return playerBelongRepository.list();
	}

	public PlayerBelongDetailResponse detail(@NonNull Integer belongId) {
		final PlayerBelongDetailAsync.Result result = playerBelongDetailAsync.async(belongId);

		return detailTranslator.translate(result);
	}
}
