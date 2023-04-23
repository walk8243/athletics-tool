package xyz.walk8243.athleticstool.repositoryapi.presentation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import xyz.walk8243.athleticstool.repositoryapi.service.PlayerService;

@RestController
@RequestMapping("/athletics/player")
@RequiredArgsConstructor
public class PlayerController {
	private final PlayerService service;

	@GetMapping("/list")
	@Operation(description = "選手一覧の取得")
	public List<?> list() {
		return service.list();
	}
}
