package xyz.walk8243.athleticstool.toolapi.presentation;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.walk8243.athleticstool.entity.domain.response.PlayerListResponse;
import xyz.walk8243.athleticstool.toolapi.service.PlayerService;

@RestController
@RequestMapping("/athletics/player")
@RequiredArgsConstructor
public class PlayerController {
	private final PlayerService service;

	@GetMapping("/list")
	@Operation(description = "選手の一覧を取得する")
	public PlayerListResponse list() {
		return service.list();
	}
}
