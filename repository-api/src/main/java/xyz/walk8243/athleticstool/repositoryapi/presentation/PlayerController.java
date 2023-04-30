package xyz.walk8243.athleticstool.repositoryapi.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerListResponse;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerResponse;
import xyz.walk8243.athleticstool.repositoryapi.service.PlayerService;

@RestController
@RequestMapping("/athletics/player")
@RequiredArgsConstructor
public class PlayerController {
	private final PlayerService service;

	@GetMapping("/{playerId}")
	@Operation(summary = "選手取得API", description = "選手IDを指定して1人の選手情報を取得する")
	public PlayerResponse get(
			@PathVariable(name = "playerId") @Parameter(name = "playerId", example = "1")
					Integer playerId) {
		return service.get(playerId);
	}

	@GetMapping("/list")
	@Operation(summary = "選手一覧API", description = "全ての選手情報を取得する")
	public PlayerListResponse list() {
		return service.list();
	}
}
