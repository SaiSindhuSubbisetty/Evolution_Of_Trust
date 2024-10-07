package org.example.Entities;

import org.example.Enums.Action;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name for Player 1:");
        String player1Name = scanner.nextLine();
        Player player1 = new Player(player1Name);

        System.out.println("Enter name for Player 2:");
        String player2Name = scanner.nextLine();
        Player player2 = new Player(player2Name);

        EvolutionOfTrustMachine machine = new EvolutionOfTrustMachine();

        System.out.println("Enter the number of rounds to simulate:");
        int rounds = scanner.nextInt();

        for (int i = 0; i < rounds; i++) {
            Action action1 = player1.chooseAction();
            Action action2 = player2.chooseAction();

            System.out.println("Round " + (i + 1) + ":");
            System.out.println(player1.getName() + " chooses " + action1);
            System.out.println(player2.getName() + " chooses " + action2);

            machine.transact(player1, action1, player2, action2);

            System.out.println(player1.getName() + " has " + player1.getCoins() + " coins.");
            System.out.println(player2.getName() + " has " + player2.getCoins() + " coins.");
            System.out.println();

        }


        System.out.println("Final Results:");
        System.out.println(player1.getName() + " has " + player1.getCoins() + " coins.");
        System.out.println(player2.getName() + " has " + player2.getCoins() + " coins.");
    }
}