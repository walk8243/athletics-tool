package xyz.walk8243.athleticstool.webapi.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerListResponse;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerResponse;
import xyz.walk8243.athleticstool.webapi.service.PlayerService;

@RestController
@RequestMapping("/athletics/player")
@RequiredArgsConstructor
public class PlayerController {
	private final PlayerService service;

	@GetMapping("/")
	@Operation(description = "選手の一覧を取得する")
	public PlayerListResponse list() {
		return service.list();
	}

	@GetMapping("/{playerId}")
	@Operation(description = "選手の一覧を取得する")
	public PlayerResponse detail(
			@PathVariable(name = "playerId") @Parameter(name = "playerId", example = "1")
					Integer playerId) {
		return service.detail(playerId);
	}
}
