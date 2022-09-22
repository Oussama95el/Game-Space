package game_space;

import java.util.HashMap;

public class Game {

    private final HashMap<String,String> games = new HashMap<>();


    public Game() {
        games.put("Football", "FIFA22");
        games.put("Football", "PES22");
        games.put("War", "Counter-Strike");
        games.put("War", "Assassin's Creed");
        games.put("RPG", "Super Smash Bros");
        games.put("RPG", "Zelda");
    }

    //getters

    public String toString(){
    return  this.games.toString();
    }

}
