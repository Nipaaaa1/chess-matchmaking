package com.nipaaaa.chess_matchmaking.player;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PlayerService {

  private final PlayerRepository playerRepository;

  public PlayerService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  public Player register(String name) {
    Player player = new Player(name);
    return playerRepository.save(player);
  }

  public List<Player> getAll() {
    return playerRepository.findAll();
  }
}
