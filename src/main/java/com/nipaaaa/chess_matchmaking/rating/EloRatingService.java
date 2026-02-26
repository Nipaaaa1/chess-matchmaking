package com.nipaaaa.chess_matchmaking.rating;

import org.springframework.stereotype.Service;

@Service
public class EloRatingService {
  private static final int K = 32;

  public int calculateNewRating(int playerRating, int opponentRating, double score) {

    double expectedScore = calculateExpectedScore(playerRating, opponentRating);

    return (int) Math.round(playerRating + K * (score - expectedScore));
  }

  public double calculateExpectedScore(int playerRating, int opponentRating) {
    return 1 / (1 + Math.pow(10, (opponentRating - playerRating) / 400));
  }
}
