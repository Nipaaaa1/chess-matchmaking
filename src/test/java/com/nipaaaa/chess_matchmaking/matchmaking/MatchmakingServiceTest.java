package com.nipaaaa.chess_matchmaking.matchmaking;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import com.nipaaaa.chess_matchmaking.match.MatchRepository;
import com.nipaaaa.chess_matchmaking.player.Player;
import com.nipaaaa.chess_matchmaking.player.PlayerRepository;
import com.nipaaaa.chess_matchmaking.player.PlayerStatus;

public class MatchmakingServiceTest {

  private final PlayerRepository playerRepository = Mockito.mock(PlayerRepository.class);

  private final MatchRepository matchRepository = Mockito.mock(MatchRepository.class);

  private final MatchmakingService matchmakingService = new MatchmakingService(playerRepository, matchRepository);

  @Test
  void shouldCreateMatchWhenTwoPlayerAreEqual() {
    Player p1 = new Player("Jamal");
    Player p2 = new Player("Udin");

    p1.setStatus(PlayerStatus.IDLE);
    p2.setStatus(PlayerStatus.IN_QUEUE);

    p1.setId(1L);
    p2.setId(2L);

    when(playerRepository.findById(1L)).thenReturn(Optional.of(p1));

    when(playerRepository.findByStatus(PlayerStatus.IN_QUEUE)).thenReturn(List.of(p2));

    matchmakingService.joinQueue(1L);

    verify(matchRepository, times(1)).save(any());

  }
}
