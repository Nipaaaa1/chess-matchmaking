package com.nipaaaa.chess_matchmaking.match;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
@RequestMapping("/match")
public class MatchController {

  private final MatchRepository matchRepository;
  private final MatchService matchService;

  public MatchController(MatchRepository matchRepository, MatchService matchService) {
    this.matchRepository = matchRepository;
    this.matchService = matchService;
  }

  @GetMapping
  public List<Match> getAll() {
    return matchRepository.findAll();
  }

  @PostMapping("/{matchId}/result")
  public void submitMatchResult(@PathVariable Long matchId, @RequestParam MatchResult result) {
    matchService.submitResult(matchId, result);
  }
}
