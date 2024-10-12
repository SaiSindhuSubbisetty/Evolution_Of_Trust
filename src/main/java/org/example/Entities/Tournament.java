package org.example.Entities;

import org.example.Exceptions.InvalidNumberOfPlayersException;
import org.example.Exceptions.InvalidNumberOfRoundsException;

import java.util.*;

public class Tournament {
    Map<Player, Integer> scores;

    public Tournament(int numberOfAlwaysCheatPlayers, int numberOfAlwaysCooperatePlayers, int numberOfCopycatPlayers) {
        if (numberOfAlwaysCheatPlayers <= 0 || numberOfAlwaysCooperatePlayers <= 0 || numberOfCopycatPlayers <= 0) {
            throw new InvalidNumberOfPlayersException("Cannot have negative number of players");
        }
        scores = new HashMap<>();
        for (int i = 0; i < numberOfAlwaysCheatPlayers; i++) {
            scores.put(new AlwaysCheatPlayer(), 0);
        }
        for (int i = 0; i < numberOfAlwaysCooperatePlayers; i++) {
            scores.put(new AlwaysCooperatePlayer(), 0);
        }
        for (int i = 0; i < numberOfCopycatPlayers; i++) {
            scores.put(new CopycatPlayer(), 0);
        }
    }

    public void playTournament(int rounds) throws CloneNotSupportedException {
        if (rounds <= 0) {
            throw new InvalidNumberOfRoundsException("Cannot have negative or zero rounds");
        }
        while (!areAllPlayersSameType()) {
            playRound(rounds);
            displayScores();
            eliminateBottomAndPromoteTop5Players();
        }

        System.out.println("\nAll remaining players are: " + scores.keySet().iterator().next().getClass().getSimpleName());
    }

    private boolean areAllPlayersSameType() {
        if (scores.size() <= 1) return true;

        Iterator<Player> iterator = scores.keySet().iterator();
        Class<?> firstPlayerClass = iterator.next().getClass();

        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (!player.getClass().equals(firstPlayerClass)) {
                return false;
            }
        }
        return true;
    }

    private void playRound(int rounds) throws CloneNotSupportedException {
        List<Player> playerList = new ArrayList<>(scores.keySet());
        int playerCount = playerList.size();

        for (int i = 0; i < playerCount; i++) {
            for (int j = i + 1; j < playerCount; j++) {
                Player player1 = (Player) playerList.get(i).clone();
                Player player2 = (Player) playerList.get(j).clone();

                EvolutionOfTrustMachine machine = new EvolutionOfTrustMachine(player1, player2);
                machine.play(rounds);

                scores.put(playerList.get(i), scores.get(playerList.get(i)) + player1.getScore());
                scores.put(playerList.get(j), scores.get(playerList.get(j)) + player2.getScore());
            }
        }
    }

    private void displayScores() {
        System.out.println("\nCurrent Iteration Scores:");
        for (Map.Entry<Player, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey().getClass().getSimpleName() + " Score: " + entry.getValue());
        }
    }

    private void eliminateBottomAndPromoteTop5Players() throws CloneNotSupportedException {
        List<Map.Entry<Player, Integer>> playerList = new ArrayList<>(scores.entrySet());

        playerList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (int i = playerList.size() - 1; i >= playerList.size() - 5; i--) {
            scores.remove(playerList.get(i).getKey());
        }

        List<Map.Entry<Player, Integer>> topFive = playerList.subList(0, 5);
        for (Map.Entry<Player, Integer> entry : topFive) {
            scores.put((Player) entry.getKey().clone(), 0);
        }
        scores.replaceAll((player, score) -> 0);
        Map<Player, Integer> sortedByType = new LinkedHashMap<>();
        scores.keySet().stream()
                .sorted(Comparator.comparing(player -> player.getClass().getSimpleName()))
                .forEach(player -> sortedByType.put(player, scores.get(player)));
        scores = sortedByType;
    }

}