package com.nipaaaa.chess_matchmaking.match;

import com.nipaaaa.chess_matchmaking.player.Player;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Match {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false)
  private Player player1;

  @ManyToOne(optional = false)
  private Player player2;

  @Enumerated(EnumType.STRING)
  private MatchStatus matchStatus;

  @Enumerated(EnumType.STRING)
  private MatchResult matchResult;

  protected Match() {
  }

  public Match(Player player1, Player player2) {
    this.player1 = player1;
    this.player2 = player2;
    this.matchStatus = MatchStatus.ONGOING;
  }

  public Long getId() {
    return id;
  }

  // Only for testing
  public void setId(Long id) {
    this.id = id;
  }

  public Player getPlayer1() {
    return player1;
  }

  public Player getPlayer2() {
    return player2;
  }

  public MatchStatus getMatchStatus() {
    return matchStatus;
  }

  public MatchResult getMatchResult() {
    return matchResult;
  }

  public void finish(MatchResult matchResult) {
    this.matchStatus = MatchStatus.FINISHED;
    this.matchResult = matchResult;
  }

}
