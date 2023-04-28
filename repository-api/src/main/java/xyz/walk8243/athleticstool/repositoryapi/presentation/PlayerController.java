package xyz.walk8243.athleticstool.repositoryapi.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import xyz.walk8243.athleticstool.repositoryapi.domain.response.PlayerListResponse;
import xyz.walk8243.athleticstool.repositoryapi.service.PlayerService;

@RestController
@RequestMapping("/athletics/player")
@RequiredArgsConstructor
public class PlayerController {
	private final PlayerService service;

	@GetMapping("/list")
	@Operation(description = "")
	public PlayerListResponse list() {
		return service.list();
	}
}
