package com.nipaaaa.chess_matchmaking.player;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

  private final PlayerService playerService;

  public PlayerController(PlayerService playerService) {
    this.playerService = playerService;
  }

  @PostMapping
  public Player registerNewPlayer(@RequestParam String name) {
    return playerService.register(name);
  }

  @GetMapping
  public List<Player> getAllPlayer() {
    return playerService.getAll();
  }

}
