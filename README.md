# Evolution_Of_Trust

---

### 📄 `README.md`

```markdown
# Evolution Of Trust - Game (Java Solution)

This project is a Java implementation of **"The Evolution of Trust"** — a game theory simulation inspired by Nicky Case's interactive explainer. The game models interactions between different types of players to study how trust evolves (or breaks down) over time.

## 📌 Project Objective

To simulate the Iterated Prisoner's Dilemma in Java by implementing different player strategies (e.g., Always Cooperate, Always Cheat, Tit-for-Tat, Grudger, Random) and observing their interactions across multiple rounds and generations.

---

## 🧠 Game Theory Background

The original **Evolution of Trust** explores how trust can emerge, evolve, and collapse based on:

- Repeated interactions
- Communication errors
- Strategy diversity
- Randomness

This project recreates that logic in Java as a learning tool and simulation.

---

## 🚀 Features

- Multiple strategies:
  - Always Cooperate
  - Always Cheat
  - Tit for Tat
  - Grudger
  - Random
- Round-based score tracking
- Customizable number of rounds per match
- Tournament-style simulation across all strategy pairs
- Console-based output of results and final rankings

---

## 🛠 Tech Stack

- Java 11+
- IDE: IntelliJ / Eclipse / VS Code (optional)
- Maven or Gradle (optional if you use a build tool)

---

## 📁 Project Structure

```
Evolution_Of_Trust/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── evolutionoftrust/
│   │               ├── Game.java
│   │               ├── Player.java
│   │               ├── strategies/
│   │               │   ├── AlwaysCooperate.java
│   │               │   ├── AlwaysCheat.java
│   │               │   ├── TitForTat.java
│   │               │   ├── Grudger.java
│   │               │   └── RandomStrategy.java
│   │               └── Tournament.java
│   └── test/
│       └── java/...
│
├── README.md
└── pom.xml / build.gradle (optional)
```

---

## 🧪 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/SaiSindhuSubbisetty/Evolution_Of_Trust.git
   cd Evolution_Of_Trust
   ```

2. Compile and run:
   - If using an IDE: Run `Game.java` or `Tournament.java`
   - If using terminal:
     ```bash
     javac -d out src/main/java/com/evolutionoftrust/**/*.java
     java -cp out com.evolutionoftrust.Tournament
     ```

---

## 📊 Sample Output

```
Match: TitForTat vs AlwaysCheat
Round 1: TitForTat - C, AlwaysCheat - D → Scores: 0 | 5
Round 2: TitForTat - D, AlwaysCheat - D → Scores: 1 | 1
...

Final Scores:
1. TitForTat - 82
2. Grudger - 76
3. AlwaysCooperate - 63
...
```

---

## ✅ Future Enhancements

- GUI-based simulation (JavaFX or Swing)
- Export results to CSV or charts
- Genetic algorithm to evolve new strategies

---

## 📜 License

This project is open-source and free to use under the MIT License.

---

## 🙏 Acknowledgements

Inspired by Nicky Case's [Evolution of Trust](https://ncase.me/trust/) and The Prisoner's Dilemma.

```
