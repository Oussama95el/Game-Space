package game_space;

import java.util.ArrayList;
import java.util.List;

import static helpers.SystemHelper.print;

public class Game {

    private static final List<String> games = new ArrayList<>();

    //getters

    public static List getGames(){
        return games;
    }


    public Game() {

    }

    public static void gameList(){
        int index = 1;
        games.add("FIFA22");
        games.add("PES22");
        games.add("Counter-Strike");
        games.add("Assassin's Creed");
        games.add("Super Smash Bros");
        games.add("Zelda");
        print("*************************************\n");
        for (String i:games){
            print( index++ +" "+i+"\n");
        }
    }

}
