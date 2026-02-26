![Java](https://img.shields.io/badge/Java-17+-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![H2 Database](https://img.shields.io/badge/Database-H2-lightgrey)
![License](https://img.shields.io/badge/License-Learning%20Project-blue)
# ♟ Chess Matchmaking System (Spring Boot)

Backend sederhana untuk sistem matchmaking catur berbasis Elo Rating.

Project ini dibuat untuk belajar:

- Domain modeling
- Matchmaking logic
- Elo rating calculation
- State management
- Unit testing dengan JUnit & Mockito


---
# 🚀 Features

✅ Register player.
✅ Player rating (default 1000).
✅ Join matchmaking queue.
✅ Auto match berdasarkan rating range (±100).
✅ Submit match result.
✅ Update rating pakai Elo algorithm.
✅ Unit test untuk business logic (tanpa perlu run server).


---
# 🧠 Tech Stack

✅ Java 25.
✅ Spring Boot 4.
✅ Spring Data JPA.
✅ H2 Database.
✅ JUnit.
✅ Mockito.


---
# 📦 Project Structure (Feature-Based)

```
com.nipaaaa.chess_matchmaking

├── player
├── match
├── matchmaking
├── rating
```


## player

Menangani domain player:

- Player entity
- PlayerStatus enum
- PlayerService
- PlayerController


## match

Menangani match:

- Match entity
- MatchStatus
- MatchResult
- MatchService
- MatchController


## matchmaking

Logic pencocokan player dalam queue.


## rating

EloRatingService 


---
# 🎯 API Endpoints


## Register Player

`POST /player?name`


## Get All Players

`GET /player`


## Join Queue

`POST /matchmaking/{playerId}`


## Get All Matches

`GET /match`


## Submit Match Result

`POST /match/{matchId}/result?result`

Possible result values:
- PLAYER1_WIN
- PLAYER2_WIN
- DRAW


---
# 🔄 Full Flow Example

1. Register 2 player
2. Kedua player join queue
3. Sistem otomatis membuat match jika rating dalam range
4. Submit result
5. Rating terupdate
6. Player kembali ke status IDLE


---
# 🧮 Elo Rating Formula

Expected score:

`1 / (1 + 10^((opponentRating - playerRating)/400))`

New rating:

`OldRating + K * (ActualScore - ExpectedScore)`

K-factor = 32

---
# 🧪 Testing

Business logic ditest menggunakan:
- JUnit
- Mockito (untuk mock repository)


Test yang ada:
- EloRatingServiceTest
- MatchmakingServiceTest
- MatchServiceTest


Untuk menjalankan test:
`./mvnw test`


---
# 📏 Scope & Limitations

Project ini sengaja dibuat sederhana:
❌ Tidak ada WebSocket.
❌ Tidak ada distributed system.
❌ Tidak ada concurrency handling kompleks.
❌ Tidak ada anti-cheat.
❌ Tidak ada game engine.

Fokus hanya pada:
✅ Matchmaking logic.
✅ Rating update.
✅ Clean architecture.
✅ Testable service layer.


---
# ▶ Run Application

`./mvnw spring-boot:run`

## H2 console bisa diakses di:

`http://localhost:8080/h2-console`


---
