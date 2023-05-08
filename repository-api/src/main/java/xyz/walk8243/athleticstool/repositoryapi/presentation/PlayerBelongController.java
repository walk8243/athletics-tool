package xyz.walk8243.athleticstool.repositoryapi.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerBelongListResponse;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerBelongResponse;
import xyz.walk8243.athleticstool.repositoryapi.service.PlayerBelongService;

@RestController
@RequestMapping("/athletics/playerbelong")
@RequiredArgsConstructor
public class PlayerBelongController {
	private final PlayerBelongService service;

	@GetMapping("/{belongId}")
	@Operation(summary = "選手取得API", description = "選手IDを指定して1人の選手情報を取得する")
	public PlayerBelongResponse get(
			@PathVariable(name = "belongId") @Parameter(name = "belongId", example = "1")
					Integer belongId) {
		return service.get(belongId);
	}

	@GetMapping("/list")
	@Operation(summary = "選手一覧API", description = "全ての選手情報を取得する")
	public PlayerBelongListResponse list() {
		return service.list();
	}
}
