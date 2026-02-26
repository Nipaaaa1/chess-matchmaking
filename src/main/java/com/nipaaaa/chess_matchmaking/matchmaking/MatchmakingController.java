package com.nipaaaa.chess_matchmaking.matchmaking;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
@RequestMapping("/matchmaking")
public class MatchmakingController {

  private final MatchmakingService matchmakingService;

  public MatchmakingController(MatchmakingService matchmakingService) {
    this.matchmakingService = matchmakingService;
  }

  @PostMapping("/{playerId}")
  public void joinQueuo(@PathVariable Long playerId) {
    matchmakingService.joinQueue(playerId);
  }
}
