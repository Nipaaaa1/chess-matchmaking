package com.nipaaaa.chess_matchmaking.matchmaking;

import com.nipaaaa.chess_matchmaking.match.Match;
import com.nipaaaa.chess_matchmaking.match.MatchRepository;
import com.nipaaaa.chess_matchmaking.player.Player;
import com.nipaaaa.chess_matchmaking.player.PlayerRepository;
import com.nipaaaa.chess_matchmaking.player.PlayerStatus;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MatchmakingService {

  private final PlayerRepository playerRepository;
  private final MatchRepository matchRepository;

  private static final int RATING_RANGE = 100;

  public MatchmakingService(PlayerRepository playerRepository, MatchRepository matchRepository) {
    this.playerRepository = playerRepository;
    this.matchRepository = matchRepository;
  }

  public void joinQueue(Long playerId) {
    Player player = playerRepository.findById(playerId).orElseThrow();

    List<Player> queuedPlayer = playerRepository.findByStatus(PlayerStatus.IN_QUEUE);

    for (Player opponent : queuedPlayer) {

      if (opponent.getId() == player.getId()) {
        continue;
      }

      int diff = Math.abs(player.getRating() - opponent.getRating());

      if (diff <= RATING_RANGE) {
        Match match = new Match(player, opponent);

        player.setStatus(PlayerStatus.IN_MATCH);
        opponent.setStatus(PlayerStatus.IN_MATCH);

        matchRepository.save(match);
        return;
      }
    }

    player.setStatus(PlayerStatus.IN_QUEUE);
  }

}
