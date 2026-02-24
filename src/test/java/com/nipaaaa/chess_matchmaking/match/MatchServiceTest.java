package com.nipaaaa.chess_matchmaking.match;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.nipaaaa.chess_matchmaking.player.Player;
import com.nipaaaa.chess_matchmaking.player.PlayerRepository;
import com.nipaaaa.chess_matchmaking.player.PlayerStatus;
import com.nipaaaa.chess_matchmaking.rating.EloRatingService;

public class MatchServiceTest {

  private final MatchRepository matchRepository = Mockito.mock(MatchRepository.class);
  private final PlayerRepository playerRepository = Mockito.mock(PlayerRepository.class);
  private final EloRatingService eloRatingService = new EloRatingService();

  private final MatchService matchService = new MatchService(matchRepository, playerRepository, eloRatingService);

  @Test
  void shouldUpdateRatingAndFinishMatch() {
    Player p1 = new Player("Jamal");
    Player p2 = new Player("Udin");

    p1.setId(1L);
    p2.setId(2L);

    Match match = new Match(p1, p2);

    match.setId(1L);

    when(matchRepository.findById(1L)).thenReturn(Optional.of(match));

    matchService.submitResult(match.getId(), MatchResult.PLAYER1_WIN);

    assertTrue(p1.getRating() > 1000);
    assertTrue(p2.getRating() < 1000);
    assertTrue(match.getMatchStatus() == MatchStatus.FINISHED);
    assertTrue(p1.getStatus() == PlayerStatus.IDLE);
    assertTrue(p2.getStatus() == PlayerStatus.IDLE);
  }
}
