package main.java.br.com.alexya.the_game_lib.entities;

import java.util.Objects;

public class Game {
    
    private String name;
    private String developer;
    private String gender;

    public Game(String name, String developer, String gender) {
        this.name = name;
        this.developer = developer;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Game game = (Game) obj;
        return Objects.equals(name, game.name) && Objects.equals(developer, game.developer) && Objects.equals(gender, game.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, developer, gender);
    }

    @Override
    public String toString() {
        return "Game: '" + name + "' | Developer: " + developer + " | Gender: " + gender;
    }
}
