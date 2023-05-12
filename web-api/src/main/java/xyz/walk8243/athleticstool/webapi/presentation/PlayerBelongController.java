package xyz.walk8243.athleticstool.webapi.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerBelongListResponse;
import xyz.walk8243.athleticstool.webapi.domain.response.PlayerBelongDetailResponse;
import xyz.walk8243.athleticstool.webapi.service.PlayerBelongService;

@RestController
@RequestMapping("/athletics/belong")
@RequiredArgsConstructor
public class PlayerBelongController {
	private final PlayerBelongService service;

	@GetMapping("/")
	@Operation(description = "選手の一覧を取得する")
	public PlayerBelongListResponse top() {
		return service.top();
	}

	@GetMapping("/{belongId}")
	@Operation(description = "選手の一覧を取得する")
	public PlayerBelongDetailResponse detail(
			@PathVariable(name = "belongId") @Parameter(name = "belongId", example = "1")
					Integer belongId) {
		return service.detail(belongId);
	}
}
