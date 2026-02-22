package com.nipaaaa.chess_matchmaking.rating;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EloRatingServiceTest {

  private final EloRatingService eloService = new EloRatingService();

  @Test
  void shouldIncreaseRatingWhenPlayerWinsAgainstEqualOpponent() {
    int playerRating = 1000;
    int opponentRating = 1000;

    int newRating = eloService.calculateNewRating(playerRating, opponentRating, 1.0);

    assertTrue(newRating > playerRating);
  }

  @Test
  void shouldDecreaseRatingWhenPlayerLoseAgainstEqualOpponent() {
    int playerRating = 1000;
    int opponentRating = 1000;

    int newRating = eloService.calculateNewRating(playerRating, opponentRating, 0.0);

    assertTrue(newRating < playerRating);
  }

  @Test
  void shouldChangeSmallerAmountWhenHigherRatedPlayerWins() {
    int playerRating = 1400;
    int opponentRating = 1000;

    int newRating = eloService.calculateNewRating(playerRating, opponentRating, 1.0);

    assertTrue(newRating - playerRating < 20);

  }

}
