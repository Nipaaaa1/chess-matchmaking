package com.nipaaaa.chess_matchmaking.match;

import org.springframework.stereotype.Service;

import com.nipaaaa.chess_matchmaking.player.Player;
import com.nipaaaa.chess_matchmaking.player.PlayerRepository;
import com.nipaaaa.chess_matchmaking.player.PlayerStatus;
import com.nipaaaa.chess_matchmaking.rating.EloRatingService;

@Service
public class MatchService {

  private final MatchRepository matchRepository;
  private final PlayerRepository playerRepository;
  private final EloRatingService eloRatingService;

  public MatchService(MatchRepository matchRepository, PlayerRepository playerRepository,
      EloRatingService eloRatingService) {
    this.matchRepository = matchRepository;
    this.playerRepository = playerRepository;
    this.eloRatingService = eloRatingService;
  }

  private double getPlayerScore(MatchResult result) {
    return switch (result) {
      case MatchResult.PLAYER1_WIN -> 1.0;
      case MatchResult.PLAYER2_WIN -> 0.0;
      case MatchResult.DRAW -> 0.5;
    };
  }

  public void submitResult(Long matchId, MatchResult result) {

    Match match = matchRepository.findById(matchId).orElseThrow();

    if (match.getMatchStatus() == MatchStatus.FINISHED) {
      throw new IllegalStateException("Match already finished");
    }

    Player p1 = match.getPlayer1();
    Player p2 = match.getPlayer2();

    double p1Score = getPlayerScore(result);
    double p2Score = 1.0 - p1Score;

    int p1NewRating = eloRatingService.calculateNewRating(p1.getRating(), p2.getRating(), p1Score);

    int p2NewRating = eloRatingService.calculateNewRating(p2.getRating(), p1.getRating(), p2Score);

    p1.setRating(p1NewRating);
    p2.setRating(p2NewRating);

    p1.setStatus(PlayerStatus.IDLE);
    p2.setStatus(PlayerStatus.IDLE);

    match.finish(result);
  }
}
