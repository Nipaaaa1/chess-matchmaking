package com.nipaaaa.chess_matchmaking.player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
  List<Player> findByStatus(PlayerStatus status);
}
