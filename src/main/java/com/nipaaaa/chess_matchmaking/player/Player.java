package com.nipaaaa.chess_matchmaking.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String username;

  private int rating;

  @Enumerated(EnumType.STRING)
  private PlayerStatus status;

  protected Player() {}

  public Player(String username) {
    this.username = username;
    this.rating = 1000;
    this.status = PlayerStatus.IDLE;
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public int getRating() {
    return rating;
  }

  public PlayerStatus getStatus() {
    return status;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public void setStatus(PlayerStatus status) {
    this.status = status;
  }
}
