package xyz.walk8243.athleticstool.toolapi.presentation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Nonnull;
import xyz.walk8243.athleticstool.toolapi.domain.PlayerResponse;

@RestController
@RequestMapping("/athletics/player")
public class PlayerController {
	
	@GetMapping("/list")
	@Operation(description = "選手の一覧を取得する")
	public PlayerListResponse list() {
		return new PlayerListResponse(List.of(
			new PlayerResponse(1, "秋元 真夏")
		));
	}

	/**
	 * PlayerListResponse
	 */
	public record PlayerListResponse(@Nonnull List<PlayerResponse> list) {}
}
