package main.java.br.com.alexya.the_game_lib.app;

import java.util.List;
import java.util.Scanner;

import main.java.br.com.alexya.the_game_lib.entities.Game;
import main.java.br.com.alexya.the_game_lib.entities.GameLib;

public class Main {

    private static GameLib gameLib = new GameLib();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        int option = 0;
        while (option != 6) {
            showMenu();
            try {
                option = Integer.parseInt(sc.nextLine());
                switch (option) {
                    case 1:
                        addNewGame();
                        break;
                    case 2:
                        addToWishList();
                        break;
                    case 3:
                        addToPlayingNowList();
                        break;
                    case 4:
                        addToBeatedList();
                        break;
                    case 5:
                        showAllLists();
                        break;
                    case 6:
                        System.out.println("See you soon!");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please, type a valid number.");
            }
            pressEnterToContinue();
        }
    }

    private static void showMenu() {
        System.out.println("\n==== GAME LIBRARY ====");
        System.out.println("1. Add a new game to your library.");
        System.out.println("2. Add a new game to your wishlist.");
        System.out.println("3. Add a game to your 'Playing Now' list.");
        System.out.println("4. Add a game to your 'Beated' list.");
        System.out.println("5. Show all lists.");
        System.out.println("6. Exit.");
        System.out.print("Choose an option: ");
    }

    private static void addNewGame() {
        System.out.println("\n--- Add A New Game ---");
        System.out.print("Game name: ");
        String name = sc.nextLine();
        System.out.print("Developer: ");
        String developer = sc.nextLine();
        System.out.print("Gender: ");
        String gender = sc.nextLine();

        Game newGame = new Game(name, developer, gender);
        gameLib.addGame(newGame);
    }

    private static void addToWishList() {
        System.out.println("\n--- Add To Wishlist ---");
        System.out.print("Game name: ");
        String name = sc.nextLine();
        System.out.print("Developer: ");
        String developer = sc.nextLine();
        System.out.print("Gender: ");
        String gender = sc.nextLine();

        Game newGame = new Game(name, developer, gender);
        gameLib.addToWishList(newGame);
    }

    private static void addToPlayingNowList() {
        System.out.println("\n--- Add to 'Playing Now' List ---");
        Game selectedGame = selectedGame(gameLib.getAllGames(), "Which game you want to play?");
        if (selectedGame != null) {
            gameLib.addToPlayingNowList(selectedGame);
        }
    }

    private static void addToBeatedList() {
        System.out.println("\n--- Add to 'Beated' List ---");
        Game selectedGame = selectedGame(gameLib.getAllGames(), "Which game you want to play?");
        if (selectedGame != null) {
            gameLib.addToPlayingNowList(selectedGame);
        }
    }

    private static void showAllLists() {
        gameLib.showAllGames();
        gameLib.showPlayingNow();
        gameLib.showBeatedList();
        gameLib.showWishList();
    }

    private static Game selectedGame(List<Game> gamelist, String message) {
        if (gamelist.isEmpty()) {
            System.out.println("You don't have games in this list.");
            return null;
        }

        System.out.println(message);
        for (int i = 0; i < gamelist.size(); i++) {
            System.out.println((i + 1) + ". " + gamelist.get(i).getName());
        }
        System.out.print("Type the game number: ");

        try {
            int choose = Integer.parseInt(sc.nextLine());
            if (choose > 0 && choose <= gamelist.size()) {
                return gamelist.get(choose - 1);
            } else {
                System.out.println("Invalid choose.");
                return null;
            } 
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid enter. Type a number.");
            return null;
        }
    }

    private static void pressEnterToContinue() {
        System.out.println("\nPress enter to continue...");
        sc.nextLine();
    }
}
