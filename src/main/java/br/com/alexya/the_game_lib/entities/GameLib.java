package main.java.br.com.alexya.the_game_lib.entities;

import java.util.ArrayList;
import java.util.List;

public class GameLib {
    
    private List<Game> allGames;
    private List<Game> playingNow;
    private List<Game> beated;
    private List<Game> wishList;

    public GameLib() {
        this.allGames = new ArrayList<>();
        this.playingNow = new ArrayList<>();
        this.beated = new ArrayList<>();
        this.wishList = new ArrayList<>();
    }

    public void addGame(Game game) {
        this.allGames.add(game);
        System.out.println("'" + game.getName() + "' has been added in your library.");
        if (wishList.contains(game)) {
            wishList.remove(game);
        }
    }

    public void addToWishList(Game game) {
        this.wishList.add(game);
        System.out.println("'" + game.getName() + "' has been added in your wishlist.");
    }

    public void addToPlayingNowList(Game game) {
        if (allGames.contains(game) && !playingNow.contains(game)) {
            this.playingNow.add(game);
            System.out.println("You started playing '" + game.getName() + "'.");
        } else if (playingNow.contains(game)) {
            System.out.println("You are already playing '" + game.getName() + "'.");
        } else {
            System.out.println("This game isn't in your library.");
        }
    }

    public void addToBeatedList(Game game) {
        if (playingNow.contains(game)) {
            this.beated.add(game);
            this.playingNow.remove(game);
            System.out.println("Congratulations! You've beated '" + game.getName() + "' already!");
        } else if (allGames.contains(game)) {
            this.beated.add(game);
            System.out.println("Wow, you've beated '" + game.getName() + "' before, so nice!");
        } else {
            System.out.println("Error: You don't have the game '" + game.getName() + "' in your library.");
        }
    }

    public void showAllGames() {
        System.out.println("\n--- My Game Library (" + allGames.size() + " games in total)---");
        for (Game game : allGames) {
            System.out.println(game);
        }
    }

    public void showPlayingNow() {
        System.out.println("\n--- Playing Now ---");
        if (playingNow.isEmpty()) {
            System.out.println("You're not playing any game right now.");
            return;
        }
        for (Game game : playingNow) {
            System.out.println(game);
        }
    }

    public void showWishList() {
        System.out.println("\n--- Wishlist ---");
        if (wishList.isEmpty()) {
            System.out.println("Your wishlist is empty.");
            return;
        }
        for (Game game : wishList) {
            System.out.println(game);
        }
    }

    public void showBeatedList() {
        System.out.println("\n--- Beated Games ---");
        if (beated.isEmpty()) {
            System.out.println("You didn't beated any game.");
            return;
        }
        for (Game game : beated) {
            System.out.println(game);
        }
    }

    public List<Game> getAllGames() {
        return allGames;
    }

    public List<Game> getPlayingNow() {
        return playingNow;
    }
}
